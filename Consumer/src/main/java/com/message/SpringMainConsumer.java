package com.message;

import com.message.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainConsumer implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringMainConsumer.class);

	@Autowired
	Consumer consumer;
	public static void main(String[] args) {
		SpringApplication.run(SpringMainConsumer.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
