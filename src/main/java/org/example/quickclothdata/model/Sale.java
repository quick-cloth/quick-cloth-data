package org.example.quickclothdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "sale")
public class Sale {
    @Id
    private UUID uuid;
    @Column
    private Integer value;
    @Column
    private LocalDate sale_date;
    @ManyToOne
    @JoinColumn(name = "wardrope_uuid")
    private Wardrope wardrope;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
