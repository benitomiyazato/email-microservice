package dev.benitomiyazato.emailmicroservice.controller;

import dev.benitomiyazato.emailmicroservice.dto.EmailRequest;
import dev.benitomiyazato.emailmicroservice.dto.EmailResponse;
import dev.benitomiyazato.emailmicroservice.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email-service")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmailResponse newEmail(@RequestBody @Valid EmailRequest emailRequest) {
        return emailService.newEmail(emailRequest);
    }
}
