package com.leorfk.SpringKafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: {}", payload.topic());
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        getKafkaMessageHeaderContent(payload);
    }

    private void getKafkaMessageHeaderContent(ConsumerRecord payload){
        for (var header: payload.headers()) {
            log.info("{}: {}", header.key(), new String(header.value(), StandardCharsets.UTF_8));
        }
    }
}
