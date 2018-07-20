package com.qa.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.domain.Trainee;
import com.qa.persistence.ITrainee;

public class TraineeService implements ITraineeService{

//	private static final Logger LOG = Logger.getLogger(ITraineeService.class);
	
	@Inject
	private ITrainee repo;
	
	@Override
	public String createTrainee(String account) {
//		LOG.info("service create trainee");
		return repo.createTrainee(account);
	}

	@Override
	public String updateTrainee(Long id, String updateInfo) {
//		LOG.info("service update trainee");
		return repo.updateTrainee(id, updateInfo);
	}

	@Override
	public String deleteTrainee(Long id) {
//		LOG.info("service delete trainee");
		return repo.deleteTrainee(id);
	}

	@Override
	public String getAllTrainees() {
//		LOG.info("service get all trainees");
		return repo.getAllTrainees();
	}

	public void setRepo(ITrainee repo) {
		this.repo = repo;
	}

}
