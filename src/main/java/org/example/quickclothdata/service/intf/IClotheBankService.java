package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IClotheBankService {
    ClotheBank saveClotheBank(ClotheBank clotheBank);
    ClotheBank findClotheBankByUuid(UUID uuid);
    Campaign saveCampaign(Campaign campaign);
    TypeCampaign findTypeCampignByUuid(UUID clotheBankUuid);
    List<Campaign> findCampaignByClotheBankUuid(UUID clotheBankUuid, LocalDate startDate, LocalDate endDate);
    List<TypeCampaign> findAllTypeCampaign();
    Donation saveDonation(Donation donation);
    List<Donation> saveDonations(List<Donation> donations);
    List<Donation> findDonationByClotheBankUuid(UUID clotheBankUuid);
    List<Order> findOrdersByClotheBankUuid(UUID clotheBankUuid, UUID orderStateUuid, UUID wardRobeUuid);
    List<OrderList> findOrderListByOrder(UUID orderUuid);
    Order findOrderByUuid(UUID orderUuid);
}
