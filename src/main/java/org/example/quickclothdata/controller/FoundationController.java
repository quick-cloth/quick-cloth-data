package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.service.intf.IFoundationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/foundation")
public class FoundationController {

    private final IFoundationService foundationService;

    public FoundationController(IFoundationService foundationService) {
        this.foundationService = foundationService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveFoundation(@RequestBody Foundation foundation) {
        return ResponseEntity.ok(foundationService.saveFoundation(foundation));
    }

    @GetMapping("/get_all/clothe_bank")
    public ResponseEntity<?> getAllFoundations(@RequestParam UUID clotheBankUuid) {
        return ResponseEntity.ok(foundationService.getAllFoundationsByClotheBank(clotheBankUuid));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getFoundation(@RequestParam UUID uuid) {
        return ResponseEntity.ok(foundationService.findFoundationByUuid(uuid));
    }

    @GetMapping("/type_meet_us/get_all")
    public ResponseEntity<?> getAllTypeMeetUs() {
        return ResponseEntity.ok(foundationService.getAllTypeMeetUs());
    }

    @GetMapping("/type_meet_us/get")
    public ResponseEntity<?> getTypeMeetUsByName(@RequestParam UUID uuid) {
        return ResponseEntity.ok(foundationService.findTypeMeetUsByUuid(uuid));
    }
}
