package com.rohit.springrabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

	@Value("${rabbit.queue.name}")
	private String exchange;
	
	@Value("${rabbit.queue.routingKey}")
	private String routingKey;
	
	private static final Logger log = LoggerFactory.getLogger(RabbitMqProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
//	public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
//		this.rabbitTemplate = rabbitTemplate;
//	}
	
	public void sendMessage(String message) {
		log.info(String.format("Message Sent -> %s", message));
		
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
	
}
