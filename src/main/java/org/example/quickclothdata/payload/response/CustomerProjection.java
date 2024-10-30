package org.example.quickclothdata.payload.response;

import org.example.quickclothdata.model.Wardrobe;

import java.util.UUID;

public interface CustomerProjection {
    UUID getUuid();
    String getName();
    String getLastName();
    String getUserName();
    String getEmail();
    String getPoints();
}
