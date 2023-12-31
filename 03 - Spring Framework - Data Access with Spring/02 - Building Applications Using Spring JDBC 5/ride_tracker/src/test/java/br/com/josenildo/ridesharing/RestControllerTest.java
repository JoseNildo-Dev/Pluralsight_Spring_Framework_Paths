package br.com.josenildo.ridesharing;

import br.com.josenildo.ridesharing.model.Ride;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestControllerTest {
    
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/rides";

    public RestControllerTest() {
        this.restTemplate = new RestTemplate();
    }
    
    @Test(timeout = 3000)
    public void getRidesTest() {
        ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
                BASE_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Ride>>() {
                });
        List<Ride> rides = ridesResponse.getBody();

        for (Ride ride : rides) {
            System.out.println("Ride name: " + ride.getName());
        }
    }

    @Test(timeout = 3000)
    public void createRideTest() {
        Ride ride = new Ride();
        ride.setName("Antwerp - Gent");
        ride.setDuration(60);

        ride = restTemplate.postForObject(BASE_URL, ride, Ride.class);

        System.out.println("Ride: " + ride);
    }
    
    @Test(timeout = 3000)
    public void getRideTest() {
        Ride ride = restTemplate.getForObject(BASE_URL + "/5", Ride.class);
        System.out.println("Ride: " + ride);
    }
    
    @Test(timeout = 3000)
    public void updateRideTest() {
        Ride ride = restTemplate.getForObject(BASE_URL + "/5", Ride.class);
        ride.setDuration(ride.getDuration() + 1);
        restTemplate.put(BASE_URL, ride);
        System.out.println("Ride name: " + ride.getName() + ", Duration: " + ride.getDuration());
    }
    
    @Test(timeout = 3000)
    public void batchUpdateTest() {
        restTemplate.getForObject(BASE_URL + "/batch", Object.class);
    }
    
    @Test(timeout = 3000)
    public void deleteRideTest() {
        restTemplate.delete( BASE_URL + "/7");
    }
    
    @Test(timeout = 3000)
    public void exceptionTest() {
        restTemplate.getForObject(BASE_URL + "/test", Ride.class);
    }

    @Test(timeout = 3000)
    public void failingBatchUpdateTest() {
        restTemplate.getForObject(BASE_URL + "/failing-batch", Object.class);
    }
}