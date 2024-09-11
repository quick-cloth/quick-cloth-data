package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Inventory;
import org.example.quickclothdata.model.Wardrope;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.service.intf.IWardRopeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ward_rope")
public class WardRopeController {
    private final IWardRopeService wardRopeService;

    public WardRopeController(IWardRopeService wardRopeService) {
        this.wardRopeService = wardRopeService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveWardRope(@RequestBody Wardrope wardrope) {
        return ResponseEntity.ok(wardRopeService.saveWardRope(wardrope));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateWardRope(@RequestBody Wardrope wardrope) {
        return ResponseEntity.ok(wardRopeService.updateWardRope(wardrope));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getWardRope(@RequestParam UUID uuid) {
        return ResponseEntity.ok(wardRopeService.findWardRopeByUuid(uuid));
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllWardRopes(@RequestParam UUID clotheBankUuid) {
        return ResponseEntity.ok(wardRopeService.finAllWardRopeByClotheBankUuid(clotheBankUuid));
    }

    @GetMapping("/inventory/get_all")
    public ResponseEntity<?> getAllInventories(@RequestParam UUID wardRopeUuid) {
        return ResponseEntity.ok(wardRopeService.findInventoriesByWardRopeUuid(wardRopeUuid));
    }

    @PostMapping("/inventory/save_all")
    public ResponseEntity<?> saveAllInventories(@RequestBody List<Inventory> inventories) {
        return ResponseEntity.ok(wardRopeService.saveInventories(inventories));
    }

    @PostMapping("/inventory/update")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(wardRopeService.updateInventory(inventory));
    }

    @PostMapping("/sale/save")
    public ResponseEntity<?> saveSale(@RequestBody SaleRequest sale) {
        return ResponseEntity.ok(wardRopeService.saveSale(sale));
    }

    @GetMapping("/sale/get_all")
    public ResponseEntity<?> getAllSales(@RequestParam UUID wardRopeUuid) {
        return ResponseEntity.ok(wardRopeService.findSalesByWardRopeUuid(wardRopeUuid));
    }

    @GetMapping("/sale_list/get_all")
    public ResponseEntity<?> getAllSaleLists(@RequestParam UUID saleUuid) {
        return ResponseEntity.ok(wardRopeService.findSaleListsBySaleUuid(saleUuid));
    }
}
