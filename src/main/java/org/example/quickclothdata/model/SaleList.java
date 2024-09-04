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
