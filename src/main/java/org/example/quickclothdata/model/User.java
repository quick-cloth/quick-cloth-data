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
@Table(name = "user")
public class User {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String last_name;
    @Column
    private String user_name;
    @Column
    private String email;
    @Column
    private BigInteger phone;
    @Column
    private Integer points;
    @Column
    private LocalDate creation_date;
    @ManyToOne
    @JoinColumn(name = "role_uuid")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "type_document_uuid")
    private TypeDocument typeDocument;
}
