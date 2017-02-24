package com.suptrip.dao;


import com.suptrip.dao.DaoFactory;
import com.suptrip.dao.jpa.JpaDaoFactory;

public abstract class DaoFactory {
	public static DaoFactory getDaoFactory() {
		return new JpaDaoFactory();
	}
	
	public abstract TripDao getTripDao();
	public abstract PaysDao getPaysDao();
	public abstract CampusDao getCampusDao();
	public abstract CommandesDao getCommandesDao();
	public abstract EtudiantsDao getEtudiantDao();
}
