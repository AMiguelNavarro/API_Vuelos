package com.sanvalero.api.vuelos.repository;

import com.sanvalero.api.vuelos.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// Query Methods

@Repository
public interface FlightsRepository extends CrudRepository<Flight, Long> {

    List<Flight> findAll();
    Flight findById(long id);
    List<Flight> findByCompany(String company);
    List<Flight> findByDestination(String destination);
    List<Flight> findByStopover(int stopovers);
    List<Flight> findByDeparture(String departure);

    void deleteByDestination(String destination);

}
