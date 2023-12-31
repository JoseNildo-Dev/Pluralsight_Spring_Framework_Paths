package br.com.josenildo.ridesharing.repository;

import br.com.josenildo.ridesharing.model.Ride;

import java.util.List;

public interface RideRepository {
    List<Ride> getRides();

    Ride createRide(Ride ride);
    
    Ride getRide(Integer id);

    Ride updateRide(Ride rideToUpdate);

    void updateRides(List<Object[]> pairs);

    void deleteRide(Integer id);
}