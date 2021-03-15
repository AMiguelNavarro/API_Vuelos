package com.sanvalero.api.vuelos.controller;

import com.sanvalero.api.vuelos.domain.Flight;
import com.sanvalero.api.vuelos.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired private FlightService flightService;
    private final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        logger.info("Se listan todos los vuelos");
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        Flight flight = flightService.findById(id);
        logger.info("Se lista el vuelo con ID -> " + id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

}
