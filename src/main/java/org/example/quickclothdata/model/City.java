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
@Table(name = "city")
public class City {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_uuid")
    private Department department;
}
