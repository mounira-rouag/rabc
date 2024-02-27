package com.example.rbac.Repositories;

import com.example.rbac.Entity.Role;
import com.example.rbac.Entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}

