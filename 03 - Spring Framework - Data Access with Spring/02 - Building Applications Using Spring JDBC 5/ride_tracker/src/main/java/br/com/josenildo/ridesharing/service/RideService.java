package br.com.josenildo.ridesharing.service;

import br.com.josenildo.ridesharing.model.Ride;

import java.util.List;

public interface RideService {
    List<Ride> getRides();

    Ride createRide(Ride ride);
    
    Ride getRide(Integer id);

    Ride updateRide(Ride ride);

    void batch();

    void deleteRide(Integer id);

    void failingBatch();
}