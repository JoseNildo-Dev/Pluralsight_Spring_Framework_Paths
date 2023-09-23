package br.com.josenildo.springdataoverview;

import br.com.josenildo.springdataoverview.entity.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataOverviewApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	public void verifyFlightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Amsterdam");
		flight.setDestination("New York");
		flight.setScheduleAt(LocalDateTime.parse("2011-12-13T12:12:00"));

		entityManager.persist(flight);

		final TypedQuery<Flight> results = entityManager
				.createQuery("SELECT f FROM Flight", Flight.class);

		final List<Flight> resultList = results.getResultList();

		assertThat(resultList)
				.hasSize(1)
				.first()
				.isEqualTo(flight);
	}

}







