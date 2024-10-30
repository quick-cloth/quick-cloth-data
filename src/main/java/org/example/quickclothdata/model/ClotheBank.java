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
@Table(name = "clothe_bank")
public class ClotheBank {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String address;
    @ManyToOne
    @JoinColumn(name = "city_uuid")
    private City city;
}
