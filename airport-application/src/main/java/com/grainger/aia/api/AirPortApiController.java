package com.grainger.aia.api;

import com.grainger.aia.entites.Airport;
import com.grainger.aia.exception.CustomExceptionHandler;
import com.grainger.aia.exception.RecordNotFoundException;
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

    /*@GetMapping(path = "/{id}")
    public Airport getAirPortInfoById(@PathVariable("id") long id){
        return airPortService.getAirportInfoById(id);
    }*/

    @GetMapping(path = "/code/{airportCode}")
    public Object getAirPortInfoByAirPortCode(@PathVariable("airportCode") String airportCode){
        Airport airport= airPortService.getAirportInfoByCode(airportCode.toUpperCase());
        if(airport == null) {
            return new CustomExceptionHandler().handleUserNotFoundException(new RecordNotFoundException("Please check airport code"));
        }
        return airport;
    }

    @GetMapping(path = "/distance/{originAirportCode}/{destinationAirportCode}")
    public Object getDistanceBetweenAirportByAirPortCode(@PathVariable(
            "originAirportCode") String originAirportCode,
                                                         @PathVariable("destinationAirportCode") String destinationAirportCode){
        Travel travel = airPortService.getDistanceInMiles(originAirportCode.toUpperCase(),
                destinationAirportCode.toUpperCase());
        if(travel == null) {
            return new CustomExceptionHandler().handleUserNotFoundException(new RecordNotFoundException("Please check airport codes"));
        }
        return travel;
    }
}
