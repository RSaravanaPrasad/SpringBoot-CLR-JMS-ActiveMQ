# SpringBoot-CLR-JMS-ActiveMQ
Producer and Consumer modules can be separately cleaned and installed with maven in the same project.
Producer and Consumer clients to be run in separate Command Line Runner windows/ processes. 
Have ActiveMQ running. Create a queue "UI-queue" .
Running producer with java -jar activeMQ-producer-1.0-SNAPSHOT.jar sends only one message.
Running consumer asynchronously java -jar activeMQ-consumer-1.0-SNAPSHOT.jar consumes the sent messages and prints on console.
Methods for sending messages as String and DTO added.
Actuator endpoints configured in application.properties
