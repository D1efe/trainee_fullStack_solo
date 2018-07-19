package com.qa.persistence.repository;

import com.qa.domain.Trainee;

public interface ITrainee {
	
	String createTrainee(String account);
	
	String updateTrainee(Long id, String updateInfo);
	
	String deleteTrainee(Long id);
	
	String getAllTrainees();
	
	Trainee findTrainee(Long id);

}
