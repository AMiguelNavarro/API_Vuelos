package com.sanvalero.api.vuelos.service;

import com.sanvalero.api.vuelos.domain.Flight;

import java.util.List;

//Aquí los métodos que yo quiera hacer, ya con el nombre que yo quiera.
public interface FlightService {

    List<Flight> findAllFlights();
    Flight findById(long id);
    List<Flight> findByDestination(String destination);
    List<Flight> findByDeparture(String departure);
    List<Flight> findByStopover(int stopover);
    void deleteByDestination(String destination);
    void deleteFlight(long id);
    void addNewFlight(Flight flight);
    void modifyFlight(long idOldFlight, Flight newFlight);


}
