package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Subject {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	@Pattern(regexp = "^[A-Za-z]$")
	String subjectName;
	@Pattern(regexp = "^[0-9]+$")
	int rating;

	public Subject () {
		
	}
	
	public Subject (Long id, String subjectName, int rating) {
		this.id = id;
		this.subjectName = subjectName;
		this.rating = rating;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}
	
}
