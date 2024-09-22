package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Campaign;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.example.quickclothdata.service.intf.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/clothe_bank")
public class ClotheBankController {
    private final IClotheBankService clotheBankService;

    public ClotheBankController(IClotheBankService clotheBankService) {
        this.clotheBankService = clotheBankService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClotheBank(@RequestBody ClotheBank clotheBank) {
        return ResponseEntity.ok(clotheBankService.saveClotheBank(clotheBank));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getClotheBank(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheBankService.findClotheBankByUuid(uuid));
    }

    @PostMapping("/campaign/save")
    public ResponseEntity<?> saveCampaign(@RequestBody Campaign campaign) {
        return ResponseEntity.ok(clotheBankService.saveCampaign(campaign));
    }

    @GetMapping("/campaign/get/clothe_bank")
    public ResponseEntity<?> getCampaign(@RequestParam UUID clotheBankUuid) {
        return ResponseEntity.ok(clotheBankService.findCampaignByClotheBankUuid(clotheBankUuid));
    }

    @GetMapping("/type_campaign/get")
    public ResponseEntity<?> getTypeCampaign(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheBankService.findTypeCampignByUuid(uuid));
    }

}
