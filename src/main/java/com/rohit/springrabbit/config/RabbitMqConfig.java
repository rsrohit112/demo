package com.rohit.springrabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbit.queue.exchange}")
	private String exchange;
	
	@Value("${{rabbit.queue.routingKey}")
	private String routingKey;
	
	//spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	//bean for exchange
	@Bean
	public TopicExchange abcd() {
		return new TopicExchange(exchange);
	}
	
	
	//bean to bind queue with exchange using routing key
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue())
				.to(abcd())
				.with(routingKey);
	}
	
	
	//Connection Factory
	//Rabbit Template
	//RabbitAdmin
	//These 3 are auto configured by spring boot. No need to explicit declare these beans
	
	
}
