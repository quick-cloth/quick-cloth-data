package org.example.quickclothdata.controller;

import org.example.quickclothdata.service.intf.ICampaignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/campaigns")
public class CampaignsController {

    ICampaignsService campaignsService;

    public CampaignsController(ICampaignsService campaignsService) {
        this.campaignsService = campaignsService;
    }


    @GetMapping("/get_active")
    public ResponseEntity<?> getActiveCampaigns() {
        return ResponseEntity.ok(campaignsService.getActiveCampaigns());
    }
}
