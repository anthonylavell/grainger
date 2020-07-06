package com.grainger.aia.controller;

import com.grainger.aia.entites.Airport;
import com.grainger.aia.services.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @PostMapping("/airport/information")
    public String displayAirportInformation( Airport airportCode, Model model,
                                            Errors errors){

        @Valid Airport airport =
                airPortService.getAirportInfoByCode(airportCode.getIataCode().toUpperCase());

        model.addAttribute("airport2",airport);
        return "information/airport";
    }

}
