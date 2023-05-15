package dev.benitomiyazato.emailmicroservice.service;

import dev.benitomiyazato.emailmicroservice.dto.EmailRequest;
import dev.benitomiyazato.emailmicroservice.model.EmailModel;
import dev.benitomiyazato.emailmicroservice.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;

    public void newEmail(EmailRequest emailRequest) {
        EmailModel emailToSave = new EmailModel();
        BeanUtils.copyProperties(emailRequest, emailToSave);
        emailToSave.setEmailSendDate(LocalDateTime.now());
//        emailToSave.setEmailStatus();

        emailRepository.save(emailToSave);
    }
}
