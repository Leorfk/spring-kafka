package com.leorfk.SpringKafka.controller;

import com.leorfk.SpringKafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;

    @PostMapping("send")
    public void send(@RequestBody String mensagem){
        producer.send(mensagem);
    }
}
