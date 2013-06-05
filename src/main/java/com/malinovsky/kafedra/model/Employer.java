package com.malinovsky.kafedra.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYER")
public class Employer {
	@Id
	@Column(name = "EMPLOYER_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "FIO", length = 70)
	private String FIO;
	@Column(name = "ADDRESS", length = 70)
	private String address;
	@Column(name = "PHONE", length = 14)
	private String phone;
	@Column(name = "EMAIL", length = 50)
	private String email;
	@Column(name = "PASSWORD", length = 50)
	private String password;
	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column(name = "INN", length = 8)
	private Integer INN;
	@Column(name = "SMENA_NUMBER", length = 4)
	private Integer smenaNumber;
	@Column(name = "MEDICAL_COEF")
	private Double medCoef;
	@Column(name = "WEEKEND_COEF")
	private Double weekCoef;
	@Column(name = "WORKDAY_COEF")
	private Double workCoef;
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;
	@ManyToOne
	@JoinColumn(name = "CAFE_ID")
	private Cafe cafe;
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<WorkHistory> history;

	public Employer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getINN() {
		return INN;
	}

	public void setINN(Integer iNN) {
		INN = iNN;
	}

	public Integer getSmenaNumber() {
		return smenaNumber;
	}

	public void setSmenaNumber(Integer smenaNumber) {
		this.smenaNumber = smenaNumber;
	}

	public Double getMedCoef() {
		return medCoef;
	}

	public void setMedCoef(Double medCoef) {
		this.medCoef = medCoef;
	}

	public Double getWeekCoef() {
		return weekCoef;
	}

	public void setWeekCoef(Double weekCoef) {
		this.weekCoef = weekCoef;
	}

	public Double getWorkCoef() {
		return workCoef;
	}

	public void setWorkCoef(Double workCoef) {
		this.workCoef = workCoef;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<WorkHistory> getHistory() {
		return history;
	}

	public void setHistory(Set<WorkHistory> history) {
		this.history = history;
	}

}
