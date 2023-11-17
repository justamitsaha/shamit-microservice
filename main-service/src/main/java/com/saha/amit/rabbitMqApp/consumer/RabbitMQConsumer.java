package com.saha.amit.rabbitMqApp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void consumeMessageFromQueue(OrderStatus orderStatus) {
//        logger.info("Message received from queue : " + orderStatus);
//    }
}
