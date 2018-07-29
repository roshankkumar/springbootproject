package com.frontend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * Users model class
 * 
 */


@Entity
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, updatable = false)
	private Long userId;
	
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Recipient> reciepents;
	
	@OneToOne
	private PrimaryAccount primaryaccount;
	
	@OneToOne
	private SavingsAccount savingsaccount;
	
	private Boolean enabled = true;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Recipient> getReciepents() {
		return reciepents;
	}

	public void setReciepents(List<Recipient> reciepents) {
		this.reciepents = reciepents;
	}

	public PrimaryAccount getPrimaryaccount() {
		return primaryaccount;
	}

	public void setPrimaryaccount(PrimaryAccount primaryaccount) {
		this.primaryaccount = primaryaccount;
	}

	public SavingsAccount getSavingsaccount() {
		return savingsaccount;
	}

	public void setSavingsaccount(SavingsAccount savingsaccount) {
		this.savingsaccount = savingsaccount;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", username=" + username + ", email=" + email + ", phone=" + phone + ", primaryaccount="
				+ primaryaccount + ", savingsaccount=" + savingsaccount + ", enabled=" + enabled + "]";
	}	
	
	
}
