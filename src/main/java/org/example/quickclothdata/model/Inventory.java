package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "inventory")
public class Inventory {
    @Id
    private UUID uuid;
    @Column
    private Integer stock;
    @Column
    private Integer minimum_stock;
    @ManyToOne
    @JoinColumn(name = "wardrope_uuid")
    private Wardrope wardrope;
    @ManyToOne
    @JoinColumn(name = "clothe_uuid")
    private Clothe clothe;
}
