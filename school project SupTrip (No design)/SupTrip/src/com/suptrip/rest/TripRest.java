package com.suptrip.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import javax.ws.rs.core.MediaType;
import com.suptrip.dao.DaoFactory;
import com.suptrip.model.Campus;
import com.suptrip.model.Trip;

@Path("/trip")
public class TripRest {
	
	@GET 
	@Path("/all")
  	@Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getAllinJSON() {
		List<Trip> listTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
		List<Campus> listCampus = DaoFactory.getDaoFactory().getCampusDao().getAllCampus();
		ArrayList<Trip> listTripByCampus = new ArrayList<Trip>();
		for(Campus CurrentCampus : listCampus)
		{
			Long CurrentIdCampus = CurrentCampus.getIdCampus();
			for(Trip CurrentTrip : listTrip)
			{
				Long CurrentIdCampusTrip = CurrentTrip.getCampus().getIdCampus();
				if(CurrentIdCampusTrip == CurrentIdCampus)
				{
					listTripByCampus.add(CurrentTrip);
				}
			}
		}
  		return listTripByCampus;
    }
  	
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trip> getTripByIdInJson(@PathParam("id") Long id)  {
    	List<Trip> listTrip = DaoFactory.getDaoFactory().getTripDao().getAllTrip();
    	System.out.println("objet"+id);
    	Campus myCampusSearch =  DaoFactory.getDaoFactory().getCampusDao().findCampusById(id);
    	
    	String campusSearch = myCampusSearch.getCampusName();
		ArrayList<Trip> listTripMatch = new ArrayList<Trip>();
		for(Trip CurrentTrip : listTrip)
		{
			String CurrentName = CurrentTrip.getCampus().getCampusName();
			if(campusSearch.equals(CurrentName))
			{
				listTripMatch.add(CurrentTrip);
			}
		}
        return listTripMatch;
    }

}
