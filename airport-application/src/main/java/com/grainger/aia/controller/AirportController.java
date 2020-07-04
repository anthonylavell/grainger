package com.grainger.aia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AirportController {
    @GetMapping("/")
    public String displayHome(){
        return "main/index";
    }
}
