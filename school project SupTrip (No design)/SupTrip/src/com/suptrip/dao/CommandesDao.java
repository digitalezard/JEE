package com.suptrip.dao;
import java.util.*;

import com.suptrip.model.Commandes;

public interface CommandesDao {
	Commandes addCommande(Commandes commande);
	Commandes findCommandeById(Long id);
	List<Commandes> getAllCommandes();
	void updateCommande(Commandes commande);
	void removeCommande(Commandes commandes);
}
