package com.main.sbp.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.sbp.kafka.model.Employee;

@Service
public class JsonKafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "topic-example-json", groupId = "myGroup")
	public void consumeJsonMessage (Employee employee) {
		log.info("Json Message Received -> {}", employee);
	}
}
