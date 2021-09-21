# Spring Boot JMS ActiveMQ Consumer

1. ActiveMQ JMS Consumer built and run as a separate CommandLineRunner.
2. ActiveMQ host is resolved from BROKER_URL property configured in config.properties
3. The DTO is constructed from received JSON message using ObjectMapper.This is when sending message as a JSON string.
4. A DTO object message can also be received when @JmsListener is applied on consumeObjectMessage method
5. Actuator endpoints configured in application.properties.
6. A sample Actuator endpoint: http://localhost:8086/manage/metrics
7. server.port for Actuator configured in different port from that of Producer if run on same host.