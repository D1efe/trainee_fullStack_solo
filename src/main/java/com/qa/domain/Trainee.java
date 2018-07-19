package com.qa.domain;

public class Trainee {

	private Long id;
	private String fName;
	private String lName;
	private String language;
	private String startMonth;

	public Trainee(long id, String fName, String lName, String language, String startMonth) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.language = language;
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

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartMonth() {
		return startMonth;
	}
}
