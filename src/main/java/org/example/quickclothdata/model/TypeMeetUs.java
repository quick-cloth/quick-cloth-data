package org.example.quickclothdata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "type_meet_us")
public class TypeMeetUs {
    @Id
    private UUID uuid;
    @Column
    private String name;
}