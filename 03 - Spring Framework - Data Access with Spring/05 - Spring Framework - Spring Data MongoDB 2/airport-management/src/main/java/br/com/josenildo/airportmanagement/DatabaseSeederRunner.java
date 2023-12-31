package br.com.josenildo.airportmanagement;


import br.com.josenildo.airportmanagement.domain.Aircraft;
import br.com.josenildo.airportmanagement.domain.FlightInformation;
import br.com.josenildo.airportmanagement.domain.FlightType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Order(1)
@ConditionalOnProperty(
        prefix = "airport",
        value = "seeding.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class DatabaseSeederRunner implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    public DatabaseSeederRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        empty();
        seed();
    }

    private void seed() {
        // Data
        FlightInformation flightOne = new FlightInformation();
        flightOne.setDelayed(false);
        flightOne.setDepartureCity("Rome");
        flightOne.setDestinationCity("Paris");
        flightOne.setDepartureDate(LocalDate.of(2019, 3, 12));
        flightOne.setType(FlightType.internacional);
        flightOne.setDurationMin(80);
        flightOne.setAircraft(new Aircraft("737", 180));
        flightOne.setDescription("Flight from Rome to Paris");

        FlightInformation flightTwo = new FlightInformation();
        flightTwo.setDelayed(false);
        flightTwo.setDepartureCity("New York");
        flightTwo.setDestinationCity("Copenhagen");
        flightTwo.setDepartureDate(LocalDate.of(2019, 5, 11));
        flightTwo.setType(FlightType.internacional);
        flightTwo.setDurationMin(600);
        flightTwo.setAircraft(new Aircraft("747", 300));
        flightTwo.setDescription("Flight from NY to Copenhagen via Rome");

        FlightInformation flightThree = new FlightInformation();
        flightThree.setDelayed(true);
        flightThree.setDepartureCity("Bruxelles");
        flightThree.setDestinationCity("Bucharest");
        flightThree.setDepartureDate(LocalDate.of(2019, 6, 12));
        flightThree.setType(FlightType.internacional);
        flightThree.setDurationMin(150);
        flightThree.setAircraft(new Aircraft("A320", 170));

        FlightInformation flightFour = new FlightInformation();
        flightFour.setDelayed(true);
        flightFour.setDepartureCity("Madrid");
        flightFour.setDestinationCity("Barcelona");
        flightFour.setDepartureDate(LocalDate.of(2019, 6, 12));
        flightFour.setType(FlightType.internacional);
        flightFour.setDurationMin(120);
        flightFour.setAircraft(new Aircraft("A319", 150));

        FlightInformation flightFive = new FlightInformation();
        flightFive.setDelayed(false);
        flightFive.setDepartureCity("Las Vegas");
        flightFive.setDestinationCity("Washington");
        flightFive.setDepartureDate(LocalDate.of(2019, 6, 10));
        flightFive.setType(FlightType.internacional);
        flightFive.setDurationMin(400);
        flightFive.setAircraft(new Aircraft("A319", 150));
        flightTwo.setDescription("Flight from LA to Washington via Paris");

        FlightInformation flightSix = new FlightInformation();
        flightSix.setDelayed(false);
        flightSix.setDepartureCity("Bucharest");
        flightSix.setDestinationCity("Rome");
        flightSix.setDepartureDate(LocalDate.of(2019, 6, 13));
        flightSix.setType(FlightType.internacional);
        flightSix.setDurationMin(110);
        flightSix.setAircraft(new Aircraft("A321 Neo", 200));

        // Seed
        List<FlightInformation> flights = Arrays.asList(
                flightOne,
                flightTwo,
                flightThree,
                flightFour,
                flightFive,
                flightSix
        );
        this.mongoTemplate.insertAll(flights);
    }


    private void empty() {
        this.mongoTemplate.remove(new Query(), FlightInformation.class);
    }
}






