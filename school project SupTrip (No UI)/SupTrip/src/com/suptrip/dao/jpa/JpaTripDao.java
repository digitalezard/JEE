package com.suptrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.suptrip.dao.AbstractDao;
import com.suptrip.dao.TripDao;
import com.suptrip.model.Trip;

public class JpaTripDao extends AbstractDao<Trip, Long>  implements TripDao {

	
	public JpaTripDao(EntityManagerFactory emf)
	{
		super(emf);
	}
	
	@Override
	public Trip addTrip(Trip trip) {
		return persist(trip);
	}

	@Override
	public Trip findTripById(Long id) {
		return findById(id);
	}
	
	public Trip findTripByName(String name) {
		return findByName(name);
	}
	

	@Override
	public List<Trip> getAllTrip() {
		return findAll();
	}

	@Override
	public void updateTrip(Trip trip) {
		update(trip);
	}

	@Override
	public void removeTrip(Trip trip) {
		remove(trip);
		
	}

}
