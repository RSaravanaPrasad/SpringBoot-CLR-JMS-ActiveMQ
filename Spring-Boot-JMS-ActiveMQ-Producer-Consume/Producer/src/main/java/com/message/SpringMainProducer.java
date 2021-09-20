package com.message;

import com.message.dto.Student;
import com.message.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainProducer implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
	Producer producer;
	public static void main(String[] args) {
		SpringApplication.run(SpringMainProducer.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// to send JSON String message
		//producer.sendStudentJSONMessage();

		// to send DTO message
		producer.sendStudentObjectMessage(new Student("ID-189", "Hari", System.currentTimeMillis()+""), "<correlationIdAsDesigned>");
	}
}
