package com.suptrip.dao;
import java.util.*;
import com.suptrip.model.Campus;

public interface CampusDao {
	Campus addCampus(Campus campus);
	Campus findCampusById(Long id);
	List<Campus> getAllCampus();
	void updateCampus(Campus campus);
	void removeCampus(Campus campus);

}
