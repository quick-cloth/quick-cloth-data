package org.example.quickclothdata.controller;

import org.example.quickclothdata.model.User;
import org.example.quickclothdata.payload.request.BankEmployeeRequest;
import org.example.quickclothdata.payload.request.FoundationEmployeeRequest;
import org.example.quickclothdata.payload.request.WardrobeEmployeeRequest;
import org.example.quickclothdata.service.intf.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUserClient(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUserClient(user));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam UUID uuid) {
        return ResponseEntity.ok(userService.findUserByUUID(uuid));
    }

    @GetMapping("/get/identification")
    public ResponseEntity<?> getIdentification(@RequestParam BigInteger identification) {
        return ResponseEntity.ok(userService.findUserByIdentification(identification));
    }

    @GetMapping("/get/username")
    public ResponseEntity<?> getUserName(@RequestParam String userName) {
        return ResponseEntity.ok(userService.findUserByUserName(userName));
    }

    @GetMapping("/get/email")
    public ResponseEntity<?> getEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserbyEmail(email));
    }

    @GetMapping("/get/phone")
    public ResponseEntity<?> getPhoneNumber(@RequestParam BigInteger phoneNumber) {
        return ResponseEntity.ok(userService.findUserByPhoneNumber(phoneNumber));
    }

    @GetMapping("/role/get/name")
    public ResponseEntity<?> getRole(@RequestParam String name) {
        return ResponseEntity.ok(userService.findRoleByName(name));
    }

    @GetMapping("/get_all/role")
    public ResponseEntity<?> getAllRole(@RequestParam String roleName) {
        return ResponseEntity.ok(userService.findUsersByRole(roleName));
    }

    @PostMapping("/bank_employee/save")
    public ResponseEntity<?> saveUserBankEmployee(@RequestBody BankEmployeeRequest user) {
        return ResponseEntity.ok(userService.saveUserBankEmployee(user));
    }

    @GetMapping("bank_employee/get")
    public ResponseEntity<?> getBankEmployeeByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.findBankEmployeeByUsername(username));
    }

    @PostMapping("/wardrope_employee/save")
    public ResponseEntity<?> saveUserWardropeEmployee(@RequestBody WardrobeEmployeeRequest user) {
        return ResponseEntity.ok(userService.saveUserWardropeEmployee(user));
    }

    @GetMapping("/wardrobe_employee/get")
    public ResponseEntity<?> getWardrobeEmployeeByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.findWarRobeEmployeeByUsername(username));
    }

    @PostMapping("/foundation_employee/save")
    public ResponseEntity<?> saveUserFoundationEmployee(@RequestBody FoundationEmployeeRequest user) {
        return ResponseEntity.ok(userService.saveUserFoundationEmployee(user));
    }

    @GetMapping("/type_document/get_all")
    public ResponseEntity<?> getAllTypeDocuments() {
        return ResponseEntity.ok(userService.getAllTypeDocument());
    }

    @GetMapping("/type_document/get")
    public ResponseEntity<?> getTypeDocument(@RequestParam UUID uuid) {
        return ResponseEntity.ok(userService.findTypeDocumentByUUID(uuid));
    }
    
    @GetMapping("/sales/get")
    public ResponseEntity<?> getSalesByCustomer(@RequestParam UUID userUuid, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.ok(userService.findSalesByUser(userUuid, startDate, endDate));
    }
}
