package com.grainger.aia.services;

import com.grainger.aia.repository.IAirportRepository;
import com.grainger.aia.entites.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportInformation {
    @Autowired
   private  IAirportRepository airportRepo;

    public Airport getInformationByCode(String airportCode){
        return (airportCode.length()>3) ? airportRepo.findByIcaoCode(airportCode) : airportRepo.findByIataCode(airportCode);
    }
}
