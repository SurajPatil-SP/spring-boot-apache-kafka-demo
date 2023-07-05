package com.main.sbp.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.kafka.model.Employee;
import com.main.sbp.kafka.producer.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	// http://localhost:8080/api/v1/kafka/publish
	@PostMapping("/publishJson")
	public ResponseEntity<String> publish(@RequestBody Employee employee) {
		kafkaProducer.sendMessage(employee);
		return ResponseEntity.ok("Json message sent to the kafka topic");
	}
}
