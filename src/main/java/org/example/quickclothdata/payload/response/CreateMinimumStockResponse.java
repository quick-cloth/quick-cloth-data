package org.example.quickclothdata.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.quickclothdata.model.Clothe;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateMinimumStockResponse {
    private UUID inventoryUuid;
    private Integer stock;
    private Integer minimumStock;
    private UUID wardrobeUuid;
    private Clothe clothe;
}
