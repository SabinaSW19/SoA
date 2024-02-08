package com.ubbcluj.review;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(ReviewApplication.class, args);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(System.getenv("RABBITMQ_URI"));
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("book_queue", false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(
					String consumerTag,
					Envelope envelope,
					AMQP.BasicProperties properties,
					byte[] body) throws IOException {

				String message = new String(body, "UTF-8");
				System.out.println("Consumer received: "+message);
			}
		};
		channel.basicConsume("book_queue", true, consumer);

	}

}
