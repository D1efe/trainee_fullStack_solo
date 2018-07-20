package com.qa.business;

public interface ITraineeService {

	String createTrainee(String account);

	String updateTrainee(Long id, String updateInfo);

	String deleteTrainee(Long id);

	String getAllTrainees();

}
