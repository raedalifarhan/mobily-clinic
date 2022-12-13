package com.ri.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ri.mc.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
