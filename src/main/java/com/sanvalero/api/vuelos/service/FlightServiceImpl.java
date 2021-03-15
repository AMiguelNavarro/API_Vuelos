package com.sanvalero.api.vuelos.service;

import com.sanvalero.api.vuelos.domain.Flight;
import com.sanvalero.api.vuelos.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired private FlightsRepository flightsRepository;

    @Override
    public List<Flight> findAllFlights() {
        return flightsRepository.findAll();
    }

    @Override
    public Flight findById(long id) {
        return flightsRepository.findById(id);
    }

    @Override
    public List<Flight> findByDestination(String destination) {
        return null;
    }

    @Override
    public List<Flight> findByDeparture(String departure) {
        return null;
    }

    @Override
    public List<Flight> findByStopover(int stopover) {
        return null;
    }

    @Override
    public void deleteByDestination(String destination) {

    }

    @Override
    public void deleteFlight(long id) {

    }

    @Override
    public void addNewFlight(Flight flight) {

    }

    @Override
    public void modifyFlight(long idOldFlight, Flight newFlight) {

    }

}
