package com.ri.mc.services;

import java.util.List;

import com.ri.mc.entity.Role;
import com.ri.mc.entity.User;

public interface UserService {
    User saveUser(User user);   
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
