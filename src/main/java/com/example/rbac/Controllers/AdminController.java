package com.example.rbac.Controllers;

import com.example.rbac.Entity.User;
import com.example.rbac.Services.UserService;
import com.example.rbac.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdministrator(@RequestBody RegisterUserDto registerUserDto) {
        User createdAdmin = (User) userService.createAdministrator(registerUserDto);

        return ResponseEntity.ok(createdAdmin);
    }
}
