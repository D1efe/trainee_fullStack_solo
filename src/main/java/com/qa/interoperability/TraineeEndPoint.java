package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.persistence.ITrainee;

@Path("/trainee")
public class TraineeEndPoint {

	@Inject
	private ITrainee service;

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String account) {
		return service.createTrainee(account);
	}

	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(Long id, String updateInfo) {
		return service.updateTrainee(id, updateInfo);
	}

	@Path("/json")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(Long id) {
		return service.deleteTrainee(id);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	public void setService(ITrainee service) {
		this.service = service;
	}
}
