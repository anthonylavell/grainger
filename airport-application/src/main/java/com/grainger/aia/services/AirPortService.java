package com.grainger.aia.services;

import com.grainger.aia.repository.IAirportRepository;
import com.grainger.aia.entites.Airport;
import com.grainger.aia.uility.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPortService {

    @Autowired
    IAirportRepository airportRepo;

    @Autowired
    AirportInformation airportInformation;

    public List<Airport> getAll(){
        return airportRepo.findAll();
    }

    public Airport getAirportInfoById(long id){
        return airportRepo.findById(id).get();
    }

    public Airport getAirportInfoByCode(String airportCode){
        return airportInformation.getInformationByCode(airportCode);
    }

    public Travel getDistanceInMiles(String originAirportCode,
                                  String destinationAirportCode){

       Airport airport1 = airportInformation.getInformationByCode(originAirportCode);
       Airport airport2 = airportInformation.getInformationByCode(destinationAirportCode);
       if(airport1 == null || airport2 == null){
           return null;
       }
       long miles = Calculate.distanceBetweenTwoPoints(airport1.getLatitude(),
               airport1.getLongitude(), airport2.getLatitude(), airport2.getLongitude());

        return new Travel(airport1.getName(),airport2.getName(),miles);
    }


}
