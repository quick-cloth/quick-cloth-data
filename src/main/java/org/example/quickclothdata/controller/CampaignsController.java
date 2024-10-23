package org.example.quickclothdata.controller;

import org.example.quickclothdata.service.intf.ICampaignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get_for_user")
    public ResponseEntity<?> getCampaignsForUser(@RequestParam UUID userUuid) {
        return ResponseEntity.ok(campaignsService.getCampaignsForUser(userUuid));
    }
    
    @DeleteMapping("/campaign/{campaignUuid}")
    public ResponseEntity<?> deleteCampaign(@PathVariable UUID campaignUuid) {
        campaignsService.deleteCampaign(campaignUuid);
        return ResponseEntity.noContent().build();
    }
}
