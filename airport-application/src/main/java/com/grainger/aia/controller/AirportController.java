package com.grainger.aia.controller;

import com.grainger.aia.entites.Airport;
import com.grainger.aia.services.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private AirPortService airPortService;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Airport> listOfAirports = airPortService.getAll();
        model.addAttribute("airports",listOfAirports);
        model.addAttribute("airport",new Airport());
        return "main/index";
    }
    @GetMapping("/distance")
    public String displayDistanceForm(){
        return "travel/distance";
    }

    @GetMapping("/airport/information")
    public String displayAirportInformation( @RequestParam("airportCode") String airportCode
            , Model model){
         Airport airport =
                airPortService.getAirportInfoByCode(airportCode.toUpperCase());
        if(airport == null){
            return "error/error404";
        }
        model.addAttribute("airport",airport);
        return "information/airport";
    }




}
