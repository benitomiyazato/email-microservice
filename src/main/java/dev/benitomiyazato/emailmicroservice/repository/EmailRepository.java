package dev.benitomiyazato.emailmicroservice.repository;

import dev.benitomiyazato.emailmicroservice.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
