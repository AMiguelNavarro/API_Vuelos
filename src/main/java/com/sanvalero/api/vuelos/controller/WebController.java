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
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sanvalero.api.vuelos.controller.Response.NOT_FOUND;

@RestController
@Tag(name = "Flights", description = "Listado de vuelos")
public class WebController {

    @Autowired private FlightService flightService;
    private final Logger logger = LoggerFactory.getLogger(WebController.class);


    /**
     * Obtiene un listado con todos los vuelos
     * @return
     */
    @Operation(summary = "Obtiene el listado de todos los vuelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vuelos",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Flight.class)))),
    })
    @GetMapping(value = "/flights", produces = "application/json")
    public ResponseEntity<List<Flight>> getAllFlights() {
        logger.info("Se listan todos los vuelos");
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    /**
     * Método que obtiene un vuelo determinado por ID
     * @param id
     * @return
     */
    @Operation(summary = "Obtiene un vuelo determinado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el vuelo", content = @Content(schema = @Schema(implementation = Flight.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping(value = "/flights/{id}", produces = "application/json")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        Flight flight = flightService.findById(id);
        logger.info("Se lista el vuelo con ID -> " + id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }


    /**
     * Método que elimina un vuelo de la BD por ID
     * @param id
     * @return
     */
    @Operation(summary = "Eliminar un vuelo determinado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado correctamente", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteFlight(@PathVariable long id) {
        logger.info("Se borra el vuelo con ID -> " +id);
        flightService.deleteFlight(id);
        return new ResponseEntity<>(Response.noErrorResponse(),HttpStatus.OK);
    }


    /**
     * Metodo para ver como tratar las excepciones
     * @param fnfe
     * @return
     */
    @ExceptionHandler(FlightNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(FlightNotFoundException fnfe){
        Response response = Response.errorResponse(NOT_FOUND, fnfe.getMessage());
        logger.error(fnfe.getMessage(),fnfe);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
