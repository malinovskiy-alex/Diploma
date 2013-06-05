package com.malinovsky.kafedra.model;

import java.util.Date;

public class WorkHistory {
	private long id;
	private Date date;
	private boolean payed;
	private DayType type;
	private Employer employer;

	public WorkHistory() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employer getEmployer() {
		return employer;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public DayType getType() {
		return type;
	}

	public void setType(DayType type) {
		this.type = type;
	}

}
