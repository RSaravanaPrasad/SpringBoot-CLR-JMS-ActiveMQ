# Spring Boot JMS ActiveMQ Producer

1. Producer built and run as a separate CommandLineRunner.
2. Sends one message in JSON or DTO format to a queue in ActiveMQ.
3. ActiveMQ host is resolved from BROKER_URL property configured in config.properties.
4. sendStudentJSONMessage() is for sending JSON String object message. // Comment sendStudentObjectMessage() when using this.
5. sendStudentObjectMessage() is for sending DTO as a message. // Comment sendStudentJSONMessage when using this.
6. server.port for Actuator configured on different port from Producer if run on same host as Consumer.
7. A sample Actuator endpoint: http://localhost:8085/manage/metrics .
