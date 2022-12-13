package com.ri.mc.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ri.mc.dao.RoleRepo;
import com.ri.mc.dao.UserRepo;
import com.ri.mc.entity.Role;
import com.ri.mc.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Step 3: implements UserDetailsService
// to tell spring how to look for the users.
@Transactional
@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    
    // Step 4: implement single function into "UserDetailsService" interface
    // uses to load user form data base or wherever they might be.
    // let spring knows our user details. 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByUsername(username);
        
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", user.getUsername());
        }

        Collection<SimpleGrantedAuthority> authorities = new LinkedHashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });;

        // assign our user and his roles to spring user
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }  




    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }


    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        // grant user role
        log.info("Adding role {} to user {}", role.getName(), user.getName());
        user.getRoles().add(role);
        
    }


    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }


    @Override
    public List<User> getUsers() {
        log.info("Fetching all user");
        return userRepo.findAll();
    }
}
