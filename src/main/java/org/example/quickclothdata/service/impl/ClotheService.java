package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.model.TypeClothe;
import org.example.quickclothdata.model.TypeGender;
import org.example.quickclothdata.model.TypeStage;
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
}
