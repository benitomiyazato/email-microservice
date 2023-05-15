package dev.benitomiyazato.emailmicroservice.controller;

import dev.benitomiyazato.emailmicroservice.dto.EmailRequest;
import dev.benitomiyazato.emailmicroservice.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/email-service")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void newEmail(@RequestBody @Valid EmailRequest emailRequest) {
        emailService.newEmail(emailRequest);
    }
}
