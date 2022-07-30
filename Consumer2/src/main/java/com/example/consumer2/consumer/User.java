package com.example.consumer2.consumer;


import com.example.consumer2.config.MessagingConfig;
import com.example.consumer2.dto.Publicacion;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Publicacion publicacion){
        System.out.println("Se recibió el siguiente mensaje en el consumidor 2:" + publicacion);
    }
}
