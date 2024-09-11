package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.BankEmployee;
import org.example.quickclothdata.model.User;
import org.example.quickclothdata.payload.request.BankEmployeeRequest;
import org.example.quickclothdata.service.intf.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUserClient(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUserClient(user));
    }

    @GetMapping("/get/identification")
    public ResponseEntity<?> getIdentification(@RequestParam BigInteger identification) {
        return ResponseEntity.ok(userService.findUserByIdentification(identification));
    }

    @GetMapping("/role/get")
    public ResponseEntity<?> getRole(@RequestParam String name) {
        return ResponseEntity.ok(userService.findRoleByName(name));
    }

    @PostMapping("/bank_employee/save")
    public ResponseEntity<?> saveUserBankEmployee(@RequestBody BankEmployeeRequest user) {
        return ResponseEntity.ok(userService.saveUserBankEmployee(user));
    }

    @GetMapping("/type_documents/get_all")
    public ResponseEntity<?> getAllTypeDocuments() {
        return ResponseEntity.ok(userService.getAllTypeDocument());
    }
}
