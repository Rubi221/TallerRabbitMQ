package com.example.consumer1.consumer;

import com.example.consumer1.config.MessagingConfig;
import com.example.consumer1.dto.Publicacion;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Publicacion publicacion){
        System.out.println("Message recieved from queue:" + publicacion);
    }
}
