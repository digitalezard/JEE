package com.suptrip.dao.jpa;

import javax.persistence.EntityManagerFactory;

import com.suptrip.dao.AbstractDao;
import com.suptrip.dao.CampusDao;
import com.suptrip.model.Campus;

import java.util.List;

public class JpaCampusDao extends AbstractDao<Campus, Long> implements CampusDao {

	protected JpaCampusDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Campus addCampus(Campus campus) {
		return persist(campus);
	}

	@Override
	public Campus findCampusById(Long id) {
		return findById(id);
	}

	@Override
	public List<Campus> getAllCampus() {
		return findAll();
	}

	@Override
	public void updateCampus(Campus campus) {
		update(campus);
	}

	@Override
	public void removeCampus(Campus campus) {
		remove(campus);
	}

	
	

}
