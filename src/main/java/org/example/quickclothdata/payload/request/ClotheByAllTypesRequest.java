package org.example.quickclothdata.payload.request;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClotheByAllTypesRequest {
    private UUID typeClotheUuid;
    private UUID typeGenderUuid;
    private UUID typeStageUuid;
}
