package com.qa.business;

import com.qa.domain.Trainee;

public interface ITraineeService {

	String createTrainee(String account);

	String updateTrainee(Long id, String updateInfo);

	String deleteTrainee(Long id);

	String getAllTrainees();

	Trainee findTrainee(Long id);

}
