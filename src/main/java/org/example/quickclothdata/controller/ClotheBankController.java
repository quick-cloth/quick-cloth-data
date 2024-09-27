package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Campaign;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.model.Donation;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.example.quickclothdata.service.intf.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/donation/save")
    public ResponseEntity<?> saveDonation(@RequestBody Donation donation) {
        return ResponseEntity.ok(clotheBankService.saveDonation(donation));
    }

    @GetMapping("/donation/get_all/clothe_bank")
    public ResponseEntity<?> getDonationByClotheBank(@RequestParam UUID clotheBankUuid) {
        return ResponseEntity.ok(clotheBankService.findDonationByClotheBankUuid(clotheBankUuid));
    }

    @PostMapping("/campaign/save")
    public ResponseEntity<?> saveCampaign(@RequestBody Campaign campaign) {
        return ResponseEntity.ok(clotheBankService.saveCampaign(campaign));
    }

    @GetMapping("/campaign/get_all/clothe_bank")
    public ResponseEntity<?> getCampaign(@RequestParam UUID clotheBankUuid, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.ok(clotheBankService.findCampaignByClotheBankUuid(clotheBankUuid, startDate, endDate));
    }

    @GetMapping("/type_campaign/get")
    public ResponseEntity<?> getTypeCampaign(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheBankService.findTypeCampignByUuid(uuid));
    }

    @GetMapping("/type_campaign/get_all")
    public ResponseEntity<?> getAllTypeCampaign() {
        return ResponseEntity.ok(clotheBankService.findAllTypeCampaign());
    }

    @GetMapping("/order/get_all")
    public ResponseEntity<?> getOrdersByClotheBank(@RequestParam UUID clotheBankUuid, @RequestParam(required = false) UUID orderStateUuid, @RequestParam(required = false) UUID wardRobeUuid) {
        return ResponseEntity.ok(clotheBankService.findOrdersByClotheBankUuid(clotheBankUuid, orderStateUuid, wardRobeUuid));
    }

    @GetMapping("/order_list/get_all")
    public ResponseEntity<?> getOrderListByOrder(@RequestParam UUID orderUuid) {
        return ResponseEntity.ok(clotheBankService.findOrderListByOrder(orderUuid));
    }

    @GetMapping("/order/get")
    public ResponseEntity<?> getOrder(@RequestParam UUID orderUuid) {
        return ResponseEntity.ok(clotheBankService.findOrderByUuid(orderUuid));
    }

}