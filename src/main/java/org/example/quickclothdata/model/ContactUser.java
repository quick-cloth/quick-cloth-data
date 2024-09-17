package org.example.quickclothdata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "contact_user")
public class ContactUser {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String last_name;
    @Column
    private BigInteger phone;
    @Column
    private String email;
}
