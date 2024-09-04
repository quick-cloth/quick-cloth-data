package org.example.quickclothdata.Controller;

import org.example.quickclothdata.service.intf.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get_all/type_documents")
    public ResponseEntity<?> getAllTypeDocuments() {
        return ResponseEntity.ok(userService.getAllTypeDocument());
    }
}
