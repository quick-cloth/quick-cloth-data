package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "bank_employee")
public class BankEmployee {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "clothe_bank_uuid")
    private ClotheBank clotheBank;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
