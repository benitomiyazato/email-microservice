package dev.benitomiyazato.emailmicroservice.dto;

import dev.benitomiyazato.emailmicroservice.enums.EmailStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequest {


    @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    private String subject;

    @NotBlank
    private String body;
}
