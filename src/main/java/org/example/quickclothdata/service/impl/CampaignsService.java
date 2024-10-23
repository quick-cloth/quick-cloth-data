package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.response.SalesByUserProjection;
import org.example.quickclothdata.repositoty.ICampaignRepository;
import org.example.quickclothdata.repositoty.IClotheRepository;
import org.example.quickclothdata.repositoty.ISaleListRepository;
import org.example.quickclothdata.repositoty.IUserRepository;
import org.example.quickclothdata.service.intf.ICampaignsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CampaignsService implements ICampaignsService {

    ICampaignRepository campaignRepository;
    ISaleListRepository saleListRepository;

    public CampaignsService(ICampaignRepository campaignRepository, ISaleListRepository saleListRepository) {
        this.campaignRepository = campaignRepository;
        this.saleListRepository = saleListRepository;
    }

    @Override
    public List<Campaign> getActiveCampaigns() {
        return campaignRepository.findAllActiveCampaigns(LocalDate.now());
    }


    public List<Campaign> getCampaignsForUser(UUID userUuid) {
        // Obtener todas las campañas activas
        List<Campaign> activeCampaigns = getActiveCampaigns();

        // Obtener todas las listas de ventas asociadas al usuario
        List<SaleList> saleListsByUserId = saleListRepository.findAllByUserUuid(userUuid);


        // Filtrar las campañas activas para incluir solo aquellas en las que el usuario ha comprado prendas que por
        // lo menos cumplan con el mismo typo de prenda que la campaña o el mismo tipo de prenda o el mismo género


        return activeCampaigns.stream().filter(campaign -> {
            for (SaleList saleList : saleListsByUserId) {
                if ((campaign.getTypeStage() == null ||
                        campaign.getTypeStage().getUuid().equals(saleList.getClothe().getTypeStage().getUuid())) &&
                        (campaign.getTypeClothe() == null ||
                                campaign.getTypeClothe().getUuid().equals(saleList.getClothe().getTypeClothe().getUuid())) &&
                        (campaign.getTypeGender() == null ||
                                campaign.getTypeGender().getUuid().equals(saleList.getClothe().getTypeGender().getUuid()))) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());

    }

    @Override
    public void deleteCampaign(UUID campaignUuid) {
        campaignRepository.deleteById(campaignUuid);
    }
}
