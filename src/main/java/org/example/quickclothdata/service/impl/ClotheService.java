package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;
import org.example.quickclothdata.payload.request.ClotheByAllTypesRequest;
import org.example.quickclothdata.payload.response.ClotheByAllTypesProjection;
import org.example.quickclothdata.repositoty.IClotheRepository;
import org.example.quickclothdata.repositoty.ITypeClotheRepository;
import org.example.quickclothdata.repositoty.ITypeGenderRepository;
import org.example.quickclothdata.repositoty.ITypeStageRepository;
import org.example.quickclothdata.service.intf.IClotheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClotheService implements IClotheService {
    private final IClotheRepository clotheRepository;
    private final ITypeClotheRepository typeClotheRepository;
    private final ITypeStageRepository typeStageRepository;
    private final ITypeGenderRepository typeGenderRepository;

    public ClotheService(IClotheRepository clotheRepository, ITypeClotheRepository typeClotheRepository, ITypeStageRepository typeStageRepository, ITypeGenderRepository typeGenderRepository) {
        this.clotheRepository = clotheRepository;
        this.typeClotheRepository = typeClotheRepository;
        this.typeStageRepository = typeStageRepository;
        this.typeGenderRepository = typeGenderRepository;
    }

    @Override
    public Clothe saveClothe(Clothe clothe) {
        return clotheRepository.save(clothe);
    }

    @Override
    public Clothe findClotheByUuid(UUID uuid) {
        return clotheRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Clothe> findAllClothes() {
        return clotheRepository.findAll();
    }

    @Override
    public List<TypeStage> getAllTypeStage() {
        return typeStageRepository.findAll();
    }

    @Override
    public TypeStage findTypeStageByName(String name) {
        return typeStageRepository.findByName(name);
    }

    @Override
    public List<TypeClothe> getAllTypeClothe() {
        return typeClotheRepository.findAll();
    }

    @Override
    public TypeClothe findTypeClotheByName(String name) {
        return typeClotheRepository.findByName(name);
    }

    @Override
    public List<TypeGender> getAllTypeGender() {
        return typeGenderRepository.findAll();
    }

    @Override
    public TypeGender findTypeGenderByName(String name) {
        return typeGenderRepository.findByName(name);
    }

    @Override
    public TypeGender findTypeGenderByUuid(UUID uuid) {
        return typeGenderRepository.findById(uuid).orElse(null);
    }

    @Override
    public TypeClothe findTypeClotheByUuid(UUID uuid) {
        return typeClotheRepository.findById(uuid).orElse(null);
    }

    @Override
    public TypeStage findTypeStageByUuid(UUID uuid) {
        return typeStageRepository.findById(uuid).orElse(null);
    }

    @Override
    public Clothe findClotheByAllTypes(ClotheByAllTypesRequest clothe) {

        ClotheByAllTypesProjection clothe1 = clotheRepository.findClothesByAllTypes(clothe.getTypeGenderUuid(), clothe.getTypeClotheUuid(), clothe.getTypeStageUuid());
        
        
        if (clothe1 == null) {
            TypeGender typeGender = typeGenderRepository.findById(clothe.getTypeGenderUuid()).orElse(null);
            TypeClothe typeClothe = typeClotheRepository.findById(clothe.getTypeClotheUuid()).orElse(null);
            TypeStage typeStage = typeStageRepository.findById(clothe.getTypeStageUuid()).orElse(null);

            return clotheRepository.save(new Clothe(typeClothe, typeGender, typeStage));
        }
        
        return new Clothe(clothe1.getUuid(),clothe1.getTypeClothe(), clothe1.getTypeGender(), clothe1.getTypeStage());
    }
    
    @Override
    public List<Clothe> findClothesByUuids(List<UUID> uuids){
        return clotheRepository.findByUuids(uuids);
    }
}
