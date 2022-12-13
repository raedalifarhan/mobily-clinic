package com.ri.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ri.mc.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
