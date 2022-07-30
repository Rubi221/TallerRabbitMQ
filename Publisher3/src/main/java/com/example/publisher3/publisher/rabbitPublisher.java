package com.example.publisher3.publisher;



import com.example.publisher3.domain.Publicacion;
import com.example.publisher3.config.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicacion")
public class rabbitPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("publica3")
    public String bookOrder(@RequestBody Publicacion publicacion) {

        template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, publicacion);
        return "Se publicó desde publisher 3 !!";
    }

}
