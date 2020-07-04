package com.grainger.aia.uility;

import com.grainger.aia.dao.IAirportRepository;
import com.grainger.aia.entites.Airport;
import org.springframework.beans.factory.annotation.Autowired;

public final class AirportInformation {
    @Autowired
   private static IAirportRepository airportRepo;

    public static Airport getInformation(String airportCode){
        if(airportCode.length()>3){
            return airportRepo.findByIcaoCode(airportCode);
        }else {
            return airportRepo.findByIataCode(airportCode);
        }
    }
}
