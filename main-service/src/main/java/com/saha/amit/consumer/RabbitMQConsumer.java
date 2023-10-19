package com.saha.amit.consumer;

import com.saha.amit.config.RabbitMQConfig;
import com.saha.amit.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void consumeMessageFromQueue(OrderStatus orderStatus) {
//        System.out.println("Message received from queue : " + orderStatus);
//    }
}
