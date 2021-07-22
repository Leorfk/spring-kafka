package com.leorfk.SpringKafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class KafkaProducer {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        var evento = new ProducerRecord<String, String>(topicName, message);
        var data = new Date().toString();
        evento.headers().add(KafkaHeaders.TIMESTAMP, data.getBytes());
        evento.headers().add(KafkaHeaders.CORRELATION_ID, UUID.randomUUID().toString().getBytes());
        evento.headers().add(new RecordHeader("transactionid", UUID.randomUUID().toString().getBytes()));
        kafkaTemplate.send(evento);
    }

}
