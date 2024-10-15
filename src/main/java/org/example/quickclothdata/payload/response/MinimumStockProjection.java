package org.example.quickclothdata.payload.response;

import org.example.quickclothdata.model.Clothe;

import java.util.UUID;

public interface MinimumStockProjection {
    UUID getInventoryUuid();
    Integer getStock();
    Integer getMinimumStock();
    UUID getWardrobeUuid();
    Clothe getClothe();
}
