package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.Campaign;

import java.util.List;
import java.util.UUID;

public interface ICampaignsService {
    List<Campaign> getActiveCampaigns();
    List<Campaign> getCampaignsForUser(UUID userUuid);
    void deleteCampaign(UUID campaignUuid);
}