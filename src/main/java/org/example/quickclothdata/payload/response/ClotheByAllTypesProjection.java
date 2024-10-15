package org.example.quickclothdata.payload.response;

import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;

import java.util.UUID;

public interface ClotheByAllTypesProjection {
    UUID getUuid();
    TypeClothe getTypeClothe();
    TypeGender getTypeGender();
    TypeStage getTypeStage();
}
