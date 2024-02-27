package com.example.rbac.Services;

import com.example.rbac.Entity.Role;
import com.example.rbac.Entity.RoleEnum;
import com.example.rbac.Entity.User;
import com.example.rbac.Repositories.RoleRepository;
import com.example.rbac.Repositories.UserRepository;
import com.example.rbac.dto.RegisterUserDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthentificationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    public String signup(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(optionalRole.get()); // Associate the user with the retrieved role

        // Save the user entity and return the saved instance
        return "user added succefully";

    }
}
