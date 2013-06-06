package com.malinovsky.kafedra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WORK_HISTORY")
public class WorkHistory {
	@Id
	@Column(name = "RECORD_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "PAYED")
	private boolean payed;
	@Column(name = "DAY_TIME")
	@Enumerated(EnumType.STRING)
	private DayType type;
	@ManyToOne
	@JoinColumn(name = "EMPLOYER_ID")
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
