package com.qa.persistence;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.domain.Trainee;
import com.qa.utility.JSONUtility;

@Transactional(TxType.SUPPORTS)
@Default
public class TraineeDBRepository implements ITrainee {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtility util;

	@Override
	@Transactional(TxType.REQUIRED)
	public String createTrainee(String account) {
		manager.persist(account);
		return account;
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateTrainee(Long id, String updateInfo) {
		String message = "";
		Trainee updatedTrainee = util.getObjectForJSON(updateInfo, Trainee.class);
		Trainee currentTrainee = findTrainee(id);
		if (updateInfo != null) {
			currentTrainee = updatedTrainee;
			manager.merge(currentTrainee);
			message = "Information successfully updated";
		} else
			message = "update was unsuccessful";
		return message;
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteTrainee(Long id) {
		String message = "";
		if (findTrainee(id) != null) {
			manager.remove(id);
			message = "Account has been removed";
		} else
			message = "Account not found";
		return message;
	}

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Override
	public Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtility util) {
		this.util = util;

	}
}