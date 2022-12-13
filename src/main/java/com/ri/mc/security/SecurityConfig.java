package com.ri.mc.security;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

 
// Step 1:

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }



    // Step 5:
    @Override
    public void configure(HttpSecurity http) throws Exception {
        
        // Disable Cross Site Request Forgery
        http.csrf();
        
        // Specify Http Session creation policy as 'STATELESS'
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        
        // Allow every one to access this application at this point.
        http.authorizeRequests().anyRequest().permitAll();

        // Add authentication filter
        // to check the user whenever they're trying to login.
        //http.addFilter(null);
    }
    
}
