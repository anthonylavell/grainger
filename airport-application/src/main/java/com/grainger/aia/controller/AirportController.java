package com.grainger.aia.controller;

import com.grainger.aia.entites.Airport;
import com.grainger.aia.services.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private AirPortService airPortService;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Airport> listOfAirports = airPortService.getAll();
        model.addAttribute("airports",listOfAirports);
        return "main/index";
    }
    @GetMapping("/distance")
    public String displayDistanceForm(Model model){

        return "travel/distance";
    }

}
