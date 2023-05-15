package dev.benitomiyazato.emailmicroservice.dto;

import dev.benitomiyazato.emailmicroservice.enums.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {

    private Long id;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String body;
    private LocalDateTime emailSendDate;
    private EmailStatus emailStatus;
}
