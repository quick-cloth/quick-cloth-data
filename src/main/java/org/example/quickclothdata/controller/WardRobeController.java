package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Inventory;
import org.example.quickclothdata.model.Wardrobe;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.service.intf.IWardRobeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/ward_rope")
public class WardRobeController {
    private final IWardRobeService wardRopeService;

    public WardRobeController(IWardRobeService wardRopeService) {
        this.wardRopeService = wardRopeService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveWardRope(@RequestBody Wardrobe wardrobe) {
        return ResponseEntity.ok(wardRopeService.saveWardRope(wardrobe));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateWardRope(@RequestBody Wardrobe wardrobe) {
        return ResponseEntity.ok(wardRopeService.updateWardRope(wardrobe));
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

    @GetMapping("/inventory/get/by")
    public ResponseEntity<?> getInventory(@RequestParam UUID clotheUuid, @RequestParam UUID wardRopeUuid) {
        return ResponseEntity.ok(wardRopeService.findInventoryByUuid(clotheUuid, wardRopeUuid));
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

    @PostMapping("/order/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest order) {
        return ResponseEntity.ok(wardRopeService.saveOrder(order));
    }

    @PostMapping("/order/confirm")
    public ResponseEntity<?> confirmOrder(@RequestBody OrderRequest order, @RequestParam UUID orderUuid) {
        return ResponseEntity.ok(wardRopeService.confirmOrder(order, orderUuid));
    }

    @GetMapping("/order_state/get/name")
    public ResponseEntity<?> getOrderStateByName(@RequestParam String orderName) {
        return ResponseEntity.ok(wardRopeService.findOrderStateByName(orderName));
    }

    @GetMapping("/order_state/get_all")
    public ResponseEntity<?> getAllOrderStates() {
        return ResponseEntity.ok(wardRopeService.findAllOrderStates());
    }
}
