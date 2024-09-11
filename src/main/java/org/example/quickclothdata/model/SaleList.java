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
@Table(name = "sale_list")
public class SaleList {
    @Id
    private UUID uuid;
    @Column
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "sale_uuid")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "clothe_uuid")
    private Clothe clothe;
}
