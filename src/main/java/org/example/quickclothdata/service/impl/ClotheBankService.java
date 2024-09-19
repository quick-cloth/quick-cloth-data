package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Campaign;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.model.TypeCampaign;
import org.example.quickclothdata.repositoty.ICampaignRepository;
import org.example.quickclothdata.repositoty.IClotheBankRepository;
import org.example.quickclothdata.repositoty.ITypeCampaignRepository;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClotheBankService implements IClotheBankService {
    private final IClotheBankRepository clotheBankRepository;
    private final ICampaignRepository campaignRepository;
    private final ITypeCampaignRepository typeCampaignRepository;


    public ClotheBankService(IClotheBankRepository clotheBankRepository, ICampaignRepository campaignRepository, ITypeCampaignRepository typeCampaignRepository) {
        this.clotheBankRepository = clotheBankRepository;
        this.campaignRepository = campaignRepository;
        this.typeCampaignRepository = typeCampaignRepository;
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

    @Override
    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public TypeCampaign findTypeCampignByUuid(UUID clotheBankUuid) {
        return typeCampaignRepository.findById(clotheBankUuid).orElse(null);
    }

    @Override
    public List<Campaign> findCampaignByClotheBankUuid(UUID clotheBankUuid) {
        return campaignRepository.findAllByClotheBankUuid(clotheBankUuid);
    }
}
