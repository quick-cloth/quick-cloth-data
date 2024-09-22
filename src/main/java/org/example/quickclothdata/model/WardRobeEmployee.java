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
@Table(name = "wardrobe_employee")
public class WardRobeEmployee {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "wardrobe_uuid")
    private Wardrobe wardrobe;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
