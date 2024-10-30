package org.example.quickclothdata.controller;

import org.example.quickclothdata.service.intf.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/location")
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
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

    @GetMapping("/city/get")
    public ResponseEntity<?> getCity(@RequestParam UUID cityUuid) {
        return ResponseEntity.ok(locationService.findCityByUuid(cityUuid));
    }
}
