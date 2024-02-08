package com.ubbcluj.book2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Book2Application {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(Book2Application.class, args);
	}

}
