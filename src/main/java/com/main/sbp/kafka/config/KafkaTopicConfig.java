package com.main.sbp.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("topic-example")
				.partitions(5)
				.build();
	}
	
	@Bean
	public NewTopic topicJson() {
		return TopicBuilder.name("topic-example-json")
				.partitions(5)
				.build();
	}
}
