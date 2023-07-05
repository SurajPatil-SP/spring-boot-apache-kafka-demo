package com.main.sbp.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.sbp.kafka.producer.KafkaProducer;

@Service
public class KafkaConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@KafkaListener(topics = "topic-example", groupId = "myGroup")
	public void consumeMessage(String message) {
		log.info("Message Received -> {}", message);
	}
}
