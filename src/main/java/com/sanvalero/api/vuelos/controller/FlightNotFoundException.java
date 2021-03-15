package com.sanvalero.api.vuelos.controller;

public class FlightNotFoundException extends RuntimeException{

    public FlightNotFoundException() {
        super();
    }

    public FlightNotFoundException(String message) {
        super(message);
    }

    public FlightNotFoundException(long id) {
        super("Vuelo no encontrado: " + id);
    }

}
