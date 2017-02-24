package com.suptrip.dao.jpa;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.suptrip.dao.AbstractDao;
import com.suptrip.dao.EtudiantsDao;
import com.suptrip.model.Etudiants;

public class JpaEtudiantsDao extends AbstractDao<Etudiants, Long>  implements EtudiantsDao{

	protected JpaEtudiantsDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Etudiants addEtudiant(Etudiants etudiants) {
		return persist(etudiants);
	}

	@Override
	public Etudiants findEtudiantById(Long id) {
		return findById(id);
	}

	@Override
	public List<Etudiants> getAllEtudiants() {
		return findAll();
	}

	@Override
	public void updateEtudiant(Etudiants etudiants) {
		update(etudiants);
		
	}

	@Override
	public void removeEtudiant(Etudiants etudiants) {
		remove(etudiants);
	}
	

}
