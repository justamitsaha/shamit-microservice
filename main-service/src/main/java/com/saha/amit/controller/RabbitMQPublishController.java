package com.saha.amit.controller;

import com.saha.amit.config.RabbitMQConfig;
import com.saha.amit.dto.Order;
import com.saha.amit.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rabbitMQ")
public class RabbitMQPublishController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("bookOrder/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        //restaurantservice
        //payment service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}
