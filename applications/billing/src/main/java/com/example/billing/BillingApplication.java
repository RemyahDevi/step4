package com.example.billing;

import com.example.payments.Gateway;
import com.example.payments.RecurlyGateway;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.Queue;

@EnableDiscoveryClient
@SpringBootApplication
public class BillingApplication {

	@Value("${queueName}")
	String queueName;



	@Bean
	BillingMessageReceiver receiver(Gateway paymentGateway) {
				return new BillingMessageReceiver(paymentGateway);
			}

			@Bean
			MessageListenerAdapter listenerAdapter(BillingMessageReceiver receiver) {
				return new MessageListenerAdapter(receiver, "process");
			}

			@Bean
		Queue queue() {
				return new Queue(queueName, false);
			}

	@Bean
	Gateway paymentGateway() {
		return new RecurlyGateway();
	}

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}
}
