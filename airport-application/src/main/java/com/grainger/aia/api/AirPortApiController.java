package com.grainger.aia.api;

import com.grainger.aia.entites.Airport;
import com.grainger.aia.services.AirPortService;
import com.grainger.aia.services.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirPortApiController {
    @Autowired
    AirPortService airPortService;

    @GetMapping
    public List<Airport> getAirPorts(){
        return airPortService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Airport getAirPortInfoById(@PathVariable("id") long id){
        return airPortService.getAirportInfoById(id);
    }

    @GetMapping(path = "/code/{airportCode}")
    public Airport getAirPortInfoByAirPortCode(@PathVariable("airportCode") String airportCode){
        return airPortService.getAirportInfoByCode(airportCode.toUpperCase());
    }

    @GetMapping(path = "/distance/{originAirportCode}/{destinationAirportCode}")
    public Travel getDistanceBetweenAirportByAirPortCode(@PathVariable(
            "originAirportCode") String originAirportCode,
                                                         @PathVariable("destinationAirportCode") String destinationAirportCode){
        return airPortService.getDistanceInMiles(originAirportCode.toUpperCase(),
                destinationAirportCode.toUpperCase());
    }
}