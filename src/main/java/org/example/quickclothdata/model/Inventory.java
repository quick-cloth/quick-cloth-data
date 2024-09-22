package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "inventory")
public class Inventory {
    @Id
    private UUID uuid;
    @Column
    private Integer stock;
    @Column
    private Integer minimum_stock;
    @Column
    private BigInteger unit_price;
    @ManyToOne
    @JoinColumn(name = "wardrobe_uuid")
    private Wardrobe wardrobe;
    @ManyToOne
    @JoinColumn(name = "clothe_uuid")
    private Clothe clothe;
}
