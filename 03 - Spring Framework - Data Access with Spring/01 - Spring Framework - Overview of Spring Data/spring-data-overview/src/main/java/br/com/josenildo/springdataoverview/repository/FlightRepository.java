package br.com.josenildo.springdataoverview.repository;

import br.com.josenildo.springdataoverview.entity.Flight;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long>, DeleteByOriginRepository {

    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginAndDestination(String london, String destination);

    List<Flight> findByOriginIn(String ... origins);

    List<Flight> findByOriginIgnoreCase(String origin);

    Page<Flight> findByOrigin(String origin, Pageable pageRequest);
}



