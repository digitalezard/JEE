package com.suptrip.dao.jpa;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.suptrip.dao.AbstractDao;
import com.suptrip.dao.PaysDao;
import com.suptrip.model.Pays;

public class JpaPaysDao extends AbstractDao<Pays, Long>  implements PaysDao{

	protected JpaPaysDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Pays addPays(Pays pays) {
		return persist(pays);
	}

	@Override
	public Pays findPaysById(Long id) {
		return findById(id);
	}

	@Override
	public List<Pays> getAllPays() {
		return findAll();
	}

	@Override
	public void updatePays(Pays pays) {
		update(pays);
	}

	@Override
	public void removePays(Pays pays) {
		remove(pays);
	}

}
