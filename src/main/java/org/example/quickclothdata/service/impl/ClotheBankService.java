package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.repositoty.*;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ClotheBankService implements IClotheBankService {
    private final IClotheBankRepository clotheBankRepository;
    private final ICampaignRepository campaignRepository;
    private final ITypeCampaignRepository typeCampaignRepository;
    private final IDonationRepository donationRepository;
    private final IOrderRepository orderRepository;
    private final IOrderListRepository orderListRepository;


    public ClotheBankService(IClotheBankRepository clotheBankRepository, ICampaignRepository campaignRepository, ITypeCampaignRepository typeCampaignRepository, IDonationRepository donationRepository, IOrderRepository orderRepository, IOrderListRepository orderListRepository) {
        this.clotheBankRepository = clotheBankRepository;
        this.campaignRepository = campaignRepository;
        this.typeCampaignRepository = typeCampaignRepository;
        this.donationRepository = donationRepository;
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
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
    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public TypeCampaign findTypeCampignByUuid(UUID clotheBankUuid) {
        return typeCampaignRepository.findById(clotheBankUuid).orElse(null);
    }

    @Override
    public List<Campaign> findCampaignByClotheBankUuid(UUID clotheBankUuid, LocalDate startDate, LocalDate endDate) {
        return campaignRepository.findAllByClotheBankUuid(clotheBankUuid, startDate, endDate);
    }

    @Override
    public List<TypeCampaign> findAllTypeCampaign() {
        return typeCampaignRepository.findAll();
    }

    @Override
    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> saveDonations(List<Donation> donations) {
        return donationRepository.saveAll(donations);
    }

    @Override
    public List<Donation> findDonationByClotheBankUuid(UUID clotheBankUuid) {
        return donationRepository.findAllByClotheBankUuid(clotheBankUuid);
    }

    @Override
    public List<Order> findOrdersByClotheBankUuid(UUID clotheBankUuid, UUID orderStateUuid, UUID wardRobeUuid) {
        return orderRepository.findAllByClotheBankUuid(clotheBankUuid, orderStateUuid, wardRobeUuid);
    }

    @Override
    public List<OrderList> findOrderListByOrder(UUID orderUuid) {
        return orderListRepository.findAllByOrderUuid(orderUuid);
    }

    @Override
    public Order findOrderByUuid(UUID orderUuid) {
        return orderRepository.findById(orderUuid).orElse(null);
    }
}
