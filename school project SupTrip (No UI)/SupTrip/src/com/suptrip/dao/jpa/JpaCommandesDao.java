package com.suptrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.suptrip.dao.AbstractDao;
import com.suptrip.dao.CommandesDao;
import com.suptrip.model.Commandes;

public class JpaCommandesDao extends AbstractDao<Commandes, Long> implements CommandesDao{

	protected JpaCommandesDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Commandes addCommande(Commandes commande) {
		return persist(commande);
	}

	@Override
	public Commandes findCommandeById(Long id) {
		return findById(id);
	}

	@Override
	public List<Commandes> getAllCommandes() {
		return findAll();
	}

	@Override
	public void updateCommande(Commandes commande) {
		update(commande);
		
	}

	@Override
	public void removeCommande(Commandes commandes) {
		remove(commandes);	
	}

}
