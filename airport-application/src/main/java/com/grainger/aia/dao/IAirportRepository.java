package com.grainger.aia.dao;


import com.grainger.aia.entites.Airport;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface IAirportRepository extends PagingAndSortingRepository<Airport,Long> {
    @Override
    public List<Airport> findAll();

    public Airport findByIcaoCode(String value);

    public Airport findByIataCode(String value);

}
