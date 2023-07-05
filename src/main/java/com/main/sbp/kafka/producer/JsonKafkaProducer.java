package com.main.sbp.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.main.sbp.kafka.model.Employee;

@Service
public class JsonKafkaProducer {
	
	private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, Employee> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage (Employee employee) {
		
		log.info("Message Sent -> {}", employee);
		
		Message<Employee> message = MessageBuilder
				.withPayload(employee)
				.setHeader(KafkaHeaders.TOPIC, "topic-example-json")
				.build();
		
		kafkaTemplate.send(message);
		
	}	
}
