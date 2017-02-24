package com.suptrip.dao;
import java.util.*;

import com.suptrip.model.Etudiants;

public interface EtudiantsDao {
	Etudiants addEtudiant(Etudiants etudiants);
	Etudiants findEtudiantById(Long id);
	List<Etudiants> getAllEtudiants();
	void updateEtudiant(Etudiants etudiants);
	void removeEtudiant(Etudiants etudiants);
}
