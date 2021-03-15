package com.sanvalero.api.vuelos.controller;

import com.sanvalero.api.vuelos.domain.Flight;
import com.sanvalero.api.vuelos.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Flights", description = "Listado de vuelos")
public class WebController {

    @Autowired private FlightService flightService;
    private final Logger logger = LoggerFactory.getLogger(WebController.class);


    @Operation(summary = "Obtiene el listado de todos los vuelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vuelos",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Flight.class)))),
    })
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        logger.info("Se listan todos los vuelos");
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }



    @Operation(summary = "Obtiene un vuelo determinado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el vuelo", content = @Content(schema = @Schema(implementation = Flight.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        Flight flight = flightService.findById(id);
        logger.info("Se lista el vuelo con ID -> " + id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }


}
