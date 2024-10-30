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
@Table(name = "campaign")
public class Campaign {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String message_campaign;
    @Column
    private LocalDate creation_date;
    @Column
    private LocalDate end_date;
    @ManyToOne
    @JoinColumn(name = "clothe_bank_uuid")
    private ClotheBank clotheBank;
    @ManyToOne
    @JoinColumn(name = "type_campaign_uuid")
    private TypeCampaign typeCampaign;
    @ManyToOne
    @JoinColumn(name = "type_clothe_uuid")
    private TypeClothe typeClothe;
    @ManyToOne
    @JoinColumn(name = "type_gender_uuid")
    private TypeGender typeGender;
    @ManyToOne
    @JoinColumn(name = "type_stage_uuid")
    private TypeStage typeStage;
    @Column
    private Integer discount;
}
