package com.leorfk.SpringKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ExemploKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploKafkaApplication.class, args);
	}

}
