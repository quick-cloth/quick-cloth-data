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
@Table(name = "clothe")
public class Clothe {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "type_clothe_uuid")
    private TypeClothe typeClothe;
    @ManyToOne
    @JoinColumn(name = "type_gender_uuid")
    private TypeGender typeGender;
    @ManyToOne
    @JoinColumn(name = "type_stage_uuid")
    private TypeStage typeStage;
    
    public Clothe(TypeClothe typeClothe, TypeGender typeGender, TypeStage typeStage) {
        this.uuid = UUID.randomUUID(); // Generate a new UUID
        this.typeClothe = typeClothe;
        this.typeGender = typeGender;
        this.typeStage = typeStage;
    }
}
