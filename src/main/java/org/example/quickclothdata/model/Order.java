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
@Table(name = "order")
public class Order {
    @Id
    private UUID uuid;
    @Column
    private LocalDate order_date;
    @Column
    private LocalDate delivery_date;
    @ManyToOne
    @JoinColumn(name = "order_state_uuid")
    private OrderState orderState;
    @ManyToOne
    @JoinColumn(name = "wardrope_uuid")
    private Wardrope wardrope;
}
