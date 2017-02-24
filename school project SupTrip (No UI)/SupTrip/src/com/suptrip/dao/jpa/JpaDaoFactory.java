package com.suptrip.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.suptrip.dao.CampusDao;
import com.suptrip.dao.CommandesDao;
import com.suptrip.dao.DaoFactory;
import com.suptrip.dao.EtudiantsDao;
import com.suptrip.dao.PaysDao;
import com.suptrip.dao.TripDao;

public class JpaDaoFactory extends DaoFactory {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private JpaTripDao tripDao;
	private JpaPaysDao paysDao;
	private JpaCampusDao campusDao;
	private JpaCommandesDao commandesDao;
	private JpaEtudiantsDao etudiantsDao;
	
	@Override
	public TripDao getTripDao() {
		if(tripDao == null) {
			tripDao = new JpaTripDao(emf);
		}
		return tripDao;
	}

	@Override
	public PaysDao getPaysDao() {
		if(paysDao == null) {
			paysDao = new JpaPaysDao(emf);
		}
		return paysDao;
	}

	@Override
	public CampusDao getCampusDao() {
		if(campusDao == null) {
			campusDao = new JpaCampusDao(emf);
		}
		return campusDao;
	}

	@Override
	public CommandesDao getCommandesDao() {
		if(commandesDao == null) {
			commandesDao = new JpaCommandesDao(emf);
		}
		return commandesDao;
	}

	@Override
	public EtudiantsDao getEtudiantDao() {
		if(etudiantsDao == null) {
			etudiantsDao = new JpaEtudiantsDao(emf);
		}
		return etudiantsDao;
	}

}
