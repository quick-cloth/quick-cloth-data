package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "foundation_employee")
public class FoundationEmployee {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "foundation_uuid")
    private Foundation foundation;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
