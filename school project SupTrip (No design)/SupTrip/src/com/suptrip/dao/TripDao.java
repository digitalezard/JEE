package com.suptrip.dao;
import java.util.*;
import com.suptrip.model.Trip;

public interface TripDao {
	Trip addTrip(Trip trip);
	Trip findTripById(Long id);
	Trip findTripByName(String Name);
	List<Trip> getAllTrip();
	void updateTrip(Trip trip);
	void removeTrip(Trip trip);
}
