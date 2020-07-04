package com.grainger.aia.services;

import com.grainger.aia.dao.IAirportRepository;
import com.grainger.aia.entites.Airport;
import com.grainger.aia.uility.AirportInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPortService {

    @Autowired
    IAirportRepository airportRepo;

    public List<Airport> getAll(){
        return airportRepo.findAll();
    }

    public Airport getAirportInfoById(long id){
        return airportRepo.findById(id).get();
    }

    public Airport getAirportInfo(String airportCode){
        return AirportInformation.getInformation(airportCode);
    }

    /*public long getDistanceInMiles(String originAirportCode,
                                  String destinationAirportCode){

       Airport airport1 = airportRepo.findByIataCode()
        return airportRepo.findByIcaoCode(value);
    }*/


}
