package com.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.dto.Student;

import java.util.UUID;

@Component
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

	// to send a JSON representation of DTO
	public Student sendStudentJSONMessage() {
		logger.info("Sending student JSON string message..");
		Student student = new Student("ID-189", "Hari", UUID.randomUUID().toString()+"" );
		try {
			ObjectMapper mapper = new ObjectMapper();
			String studentAsJson = mapper.writeValueAsString(student);
			jmsTemplate.convertAndSend(queue, studentAsJson);
			logger.info("Sent student JSON message.. "+studentAsJson);
		} catch (Exception e) {
			logger.error("Error sending message: "+e.getLocalizedMessage());
		}
		return student;
	}

	// to send a DTO as message
	public void sendStudentObjectMessage(final Student student, String correlationId) {
		logger.info("Sending message .."+correlationId);
		try{
			jmsTemplate.convertAndSend(queue, student, jmsAttrib->{
					jmsAttrib.setJMSCorrelationID(correlationId);
					return jmsAttrib;
				});
			logger.info("Sent message");
		}
		catch(Exception exc){logger.error("Error sending message: "+exc.getLocalizedMessage());}
	}

}
