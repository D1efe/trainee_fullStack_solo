package com.qa.persistence;

public interface ITrainee {
	
	String createTrainee(String account);
	
	String updateTrainee(Long id, String updateInfo);
	
	String deleteTrainee(Long id);
	
	String getAllTrainees();

}
