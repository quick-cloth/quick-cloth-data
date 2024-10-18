package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.Campaign;

import java.util.List;

public interface ICampaignsService {
    List<Campaign> getActiveCampaigns();
}