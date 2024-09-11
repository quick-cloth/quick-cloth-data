package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.service.intf.IClotheBankService;
import org.example.quickclothdata.service.intf.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clothe_bank")
public class ClotheBankController {
    private final IClotheBankService clotheBankService;
    private final ILocationService locationService;

    public ClotheBankController(IClotheBankService clotheBankService, ILocationService locationService) {
        this.clotheBankService = clotheBankService;
        this.locationService = locationService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClotheBank(@RequestBody ClotheBank clotheBank) {
        return ResponseEntity.ok(clotheBankService.saveClotheBank(clotheBank));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getClotheBank(@RequestParam UUID uuid) {
        return ResponseEntity.ok(clotheBankService.findClotheBankByUuid(uuid));
    }

    @GetMapping("/get_all/foundation")
    public ResponseEntity<?> getAllClotheBanks(@RequestParam UUID foundationUuid) {
        return ResponseEntity.ok(clotheBankService.getAllClotheBanksByFoundation(foundationUuid));
    }

    @GetMapping("/department/get_all")
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(locationService.getAllDepartments());
    }

    @GetMapping("/department/get")
    public ResponseEntity<?> getDepartment(@RequestParam UUID uuid) {
        return ResponseEntity.ok(locationService.findDepartmentByUuid(uuid));
    }

    @GetMapping("/city/get_all/by")
    public ResponseEntity<?> getAllCities(@RequestParam UUID departmentUuid) {
        return ResponseEntity.ok(locationService.getAllCitiesByDepartment(departmentUuid));
    }
}
