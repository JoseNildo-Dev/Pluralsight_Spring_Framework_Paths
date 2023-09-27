package br.com.josenildo.airportmanagement.db;

import br.com.josenildo.airportmanagement.domain.FlightInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

    List<FlightInformation> findByDepartureCityAndDestinationCity(String departure, String destination);

    @Query("{'aircraft.mbSeats' : {$gte: $0}}")
    List<FlightInformation> findByMinAircraftNbSeats(int minNbSeats);
}
