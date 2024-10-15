package org.example.quickclothdata.payload.response;

import org.example.quickclothdata.model.Wardrobe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public interface SalesByUserProjection {
    UUID getUuid();
    LocalDate getSaleDate();
    BigDecimal getValue();
    BigInteger getPayPoints();
    Wardrobe getWardrobe();
}
