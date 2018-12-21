package org.com.model;

import java.time.LocalDate;

public class PersonWithDate {

	private String name;
	private LocalDate dob;

	public PersonWithDate(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	public PersonWithDate() {
		super();
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "PersonWithDate [name=" + name + ", dob=" + dob + "]";
	}



}
