package com.example.publisher1.publisher;

import com.example.publisher1.config.MqConfig;
import com.example.publisher1.domain.Publicacion;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicacion")
public class rabbitPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("publica1")
    public String bookOrder(@RequestBody Publicacion publicacion) {

        template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, publicacion);
        return "Se publlicó desde publisher 1 !!";
    }

}
