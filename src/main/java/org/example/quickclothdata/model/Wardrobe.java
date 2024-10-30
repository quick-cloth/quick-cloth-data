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
@Table(name = "wardrobe")
public class Wardrobe {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private LocalDate creation_date;
    @Column
    private String address;
    @ManyToOne
    @JoinColumn(name = "clothe_bank_uuid")
    private ClotheBank clotheBank;
    @ManyToOne
    @JoinColumn(name = "city_uuid")
    private City city;
}
