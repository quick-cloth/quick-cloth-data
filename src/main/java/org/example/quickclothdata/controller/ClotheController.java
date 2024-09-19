package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.Clothe;
import org.example.quickclothdata.service.intf.IClotheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/clothe")
public class ClotheController {

    private final IClotheService clotheService;

    public ClotheController(IClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClothe(@RequestBody Clothe clothe) {
        return ResponseEntity.ok(clotheService.saveClothe(clothe));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getClothe(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheService.findClotheByUuid(uuid));
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllClothes() {
        return ResponseEntity.ok(clotheService.findAllClothes());
    }

    @GetMapping("/type_gender/get_all")
    public ResponseEntity<?> getAllTypeGender() {
        return ResponseEntity.ok(clotheService.getAllTypeGender());
    }

    @GetMapping("/type_gender/get")
    public ResponseEntity<?> getTypeGender(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheService.findTypeGenderByUuid(uuid));
    }

    @GetMapping("/type_clothe/get_all")
    public ResponseEntity<?> getAllTypeClothe() {
        return ResponseEntity.ok(clotheService.getAllTypeClothe());
    }

    @GetMapping("/type_clothe/get")
    public ResponseEntity<?> getTypeClothe(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheService.findTypeClotheByUuid(uuid));
    }

    @GetMapping("/type_stage/get_all")
    public ResponseEntity<?> getAllTypeStage() {
        return ResponseEntity.ok(clotheService.getAllTypeStage());
    }

    @GetMapping("/type_stage/get")
    public ResponseEntity<?> getTypeStage(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheService.findTypeStageByUuid(uuid));
    }
}
