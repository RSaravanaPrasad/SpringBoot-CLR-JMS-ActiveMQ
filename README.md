# SpringBoot-CLR-JMS-ActiveMQ
1. Producer and Consumer modules can be separately cleaned and installed with maven in the same project.
2. Producer and Consumer clients to be run in separate Command Line Runner windows/ processes. 
3. Have ActiveMQ running. Create a queue "UI-queue" .
4. Running producer with java -jar activeMQ-producer-1.0-SNAPSHOT.jar sends only one message.
5. Running consumer asynchronously java -jar activeMQ-consumer-1.0-SNAPSHOT.jar consumes the sent messages and prints on console.
6. Methods for sending messages as String and DTO added.
7. Actuator endpoints configured in application.properties
