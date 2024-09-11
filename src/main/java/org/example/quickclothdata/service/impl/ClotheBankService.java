package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.repositoty.IClotheBankRepository;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClotheBankService implements IClotheBankService {
    private final IClotheBankRepository clotheBankRepository;


    public ClotheBankService(IClotheBankRepository clotheBankRepository) {
        this.clotheBankRepository = clotheBankRepository;
    }


    @Override
    public ClotheBank saveClotheBank(ClotheBank clotheBank) {
        return clotheBankRepository.save(clotheBank);
    }

    @Override
    public ClotheBank findClotheBankByUuid(UUID uuid) {
        return clotheBankRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<ClotheBank> getAllClotheBanksByFoundation(UUID foundationUuid) {
        return clotheBankRepository.findAllByFoundationUuid(foundationUuid);
    }
}
