package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;

import java.util.List;
import java.util.UUID;

public interface IClotheBankService {
    ClotheBank saveClotheBank(ClotheBank clotheBank);
    ClotheBank findClotheBankByUuid(UUID uuid);
    Campaign saveCampaign(Campaign campaign);
    TypeCampaign findTypeCampignByUuid(UUID clotheBankUuid);
    List<Campaign> findCampaignByClotheBankUuid(UUID clotheBankUuid);
}
