package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "foundation")
public class Foundation {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private Integer nit;
    @Column
    private String legal_representative;
    @Column
    private BigInteger phone;
    @Column
    private String email;
    @Column
    private LocalDate creation_date;
    @ManyToOne
    @JoinColumn(name = "type_meet_us_uuid")
    private TypeMeetUs typeMeetUs;
    @ManyToOne
    @JoinColumn(name = "contact_user_uuid")
    private ContactUser contactUser;
    @ManyToOne
    @JoinColumn(name = "clothe_bank_uuid")
    private ClotheBank clotheBank;
    @ManyToOne
    @JoinColumn(name = "city_uuid")
    private City city;
}
