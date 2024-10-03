package org.example.quickclothdata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "send_email")
public class SendEmail {
    @Id
    private UUID uuid;
    @Column
    private String email;
    @Column
    private LocalDate send_date;
}
