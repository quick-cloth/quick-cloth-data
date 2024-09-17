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
@Table(name = "wardrope_employee")
public class WardRopeEmployee {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "wardrope_uuid")
    private Wardrope wardRope;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
