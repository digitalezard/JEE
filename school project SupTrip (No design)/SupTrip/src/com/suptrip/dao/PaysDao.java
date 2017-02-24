package com.suptrip.dao;
import java.util.*;
import com.suptrip.model.Pays;

public interface PaysDao {
	Pays addPays(Pays pays);
	Pays findPaysById(Long id);
	List<Pays> getAllPays();
	void updatePays(Pays pays);
	void removePays(Pays pays);
}
