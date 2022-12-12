package com.ri.mc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClinicController {

    @GetMapping("/")
    public String Index() {
        return "Hello World!";
    }
    
}
