package org.example.quickclothdata.payload.response;

import java.util.UUID;

public interface CustomerProjection {
    UUID getUuid();
    String getName();
    String getLastName();
    String getUserName();
    String getPoints();
}
