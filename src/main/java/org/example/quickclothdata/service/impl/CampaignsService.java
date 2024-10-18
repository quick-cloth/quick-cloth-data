package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Campaign;
import org.example.quickclothdata.model.SaleList;
import org.example.quickclothdata.model.User;
import org.example.quickclothdata.payload.response.SalesByUserProjection;
import org.example.quickclothdata.repositoty.ICampaignRepository;
import org.example.quickclothdata.repositoty.ISaleListRepository;
import org.example.quickclothdata.repositoty.IUserRepository;
import org.example.quickclothdata.service.intf.ICampaignsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CampaignsService implements ICampaignsService {

    ICampaignRepository campaignRepository;
    IUserRepository userRepository;
    ISaleListRepository saleListRepository;

    public CampaignsService(ICampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public List<Campaign> getActiveCampaigns() {
        return campaignRepository.findAllActiveCampaigns(LocalDate.now());
    }
}
