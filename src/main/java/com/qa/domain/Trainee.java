package com.qa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Pattern(regexp = "^[A-Za-z]$")
	private String fName;
	@Pattern(regexp = "^[A-Za-z]$")
	private String lName;
	@JoinColumn(name = "trainee_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Subject> subject;
	@Size(min = 3, max = 9)
	private String startMonth;

	public Trainee(String fName, String lName, String startMonth) {
		this.fName = fName;
		this.lName = lName;
		this.startMonth = startMonth;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfName() {
		return fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getlName() {
		return lName;
	}
	
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartMonth() {
		return startMonth;
	}
}
