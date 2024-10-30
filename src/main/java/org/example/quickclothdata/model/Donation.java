package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "donation")
public class Donation {
    @Id
    private UUID uuid;
    @Column
    private LocalDate creation_date;
    @ManyToOne
    @JoinColumn(name = "clothe_bank_uuid")
    private ClotheBank clothe_bank;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "clothe_uuid")
    private Clothe clothe;
    @Column
    private Integer quantity;
}
