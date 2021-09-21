package com.message.consumer;

import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.dto.Student;

import java.util.Map;

@Component
@PropertySource("classpath:config.properties")
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	//@JmsListener(destination = "${UI_QUEUE_NAME}")
	public void consumeJSONMessage(String message) {
		logger.info("Student JSON message object received from activemq.");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Student student = objectMapper.readValue(message, Student.class);
			logger.info("Student JSON bean: id: "+student.getStudentId()+" name: "+ student.getName() +" roll: "+ student.getRollNumber());
		} catch (Exception exc) {
			logger.error("Error consuming message: "+exc.getLocalizedMessage());
		}
	}

	@JmsListener(destination = "${UI_QUEUE_NAME}")
	public void consumeObjectMessage(@Payload Student student,
							   @Header(JmsHeaders.CORRELATION_ID) String correlationId,
							   @Headers Map<String, Object> headers){
		logger.info("Student message object received from activemq.");
		logger.info("Received headers: "+headers);
		try {
			// process here
			logger.info("=> Message content - Correlation id: "+correlationId+" Student Object Message bean: id: "+student.getStudentId()+" name: "+ student.getName() +" roll: "+ student.getRollNumber());
		} catch (Exception exc) {
			logger.error("Error consuming message: "+exc.getLocalizedMessage());
		}
	}

}
