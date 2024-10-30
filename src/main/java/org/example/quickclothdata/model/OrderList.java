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
