package dev.benitomiyazato.emailmicroservice.service;

import dev.benitomiyazato.emailmicroservice.dto.EmailRequest;
import dev.benitomiyazato.emailmicroservice.dto.EmailResponse;
import dev.benitomiyazato.emailmicroservice.enums.EmailStatus;
import dev.benitomiyazato.emailmicroservice.model.EmailModel;
import dev.benitomiyazato.emailmicroservice.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    public EmailResponse newEmail(EmailRequest emailRequest) {
        EmailModel emailToSave = new EmailModel();
        BeanUtils.copyProperties(emailRequest, emailToSave);
        emailToSave.setEmailSendDate(LocalDateTime.now());
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(emailToSave.getEmailFrom());
            mail.setTo(emailToSave.getEmailTo());
            mail.setSubject(emailToSave.getSubject());
            mail.setText(emailToSave.getBody());
            mailSender.send(mail);

            emailToSave.setEmailStatus(EmailStatus.SENT);
        } catch(MailException e) {
            e.printStackTrace();
            emailToSave.setEmailStatus(EmailStatus.ERROR);
        }
        EmailModel savedEmail = emailRepository.save(emailToSave);
        EmailResponse emailResponse = new EmailResponse();
        BeanUtils.copyProperties(savedEmail, emailResponse);
        System.out.println(emailResponse.getEmailStatus());
        return emailResponse;
    }
}
