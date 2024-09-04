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
@Table(name = "order_list")
public class OrderList {
    @Id
    private UUID uuid;
    @Column
    private Integer value_order;
    @Column
    private Integer delivery_value;
    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "clothe_uuid")
    private Clothe clothe;
}
