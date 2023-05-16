package dev.benitomiyazato.emailmicroservice.consumer;

import dev.benitomiyazato.emailmicroservice.dto.EmailRequest;
import dev.benitomiyazato.emailmicroservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailRequest emailRequest) {
        System.out.println("Listened to email request, sending to: " + emailRequest.getEmailTo());
        emailService.newEmail(emailRequest);
    }
}
