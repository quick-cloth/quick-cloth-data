package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;

import java.util.List;
import java.util.UUID;

public interface IClotheService {
    Clothe saveClothe(Clothe clothe);
    Clothe findClotheByUuid(UUID uuid);
    List<Clothe> findAllClothes();
    List<TypeStage> getAllTypeStage();
    TypeStage findTypeStageByName(String name);
    List<TypeClothe> getAllTypeClothe();
    TypeClothe findTypeClotheByName(String name);
    List<TypeGender> getAllTypeGender();
    TypeGender findTypeGenderByName(String name);
}
