package com.frontend.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Savings Trasaction model class
 * 
 */


@Entity
public class SavingsTransaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date transactionDate;
	private String status; 
	private String description;
	private String type;
	private Double amount;
	
	private BigDecimal availableBalance;
	
	@ManyToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savingsaccount;
	
	public SavingsTransaction() {
		
	}

	public SavingsTransaction(Date date, String status, String description, String type, Double amount,
			BigDecimal availableBalance, SavingsAccount savingsaccount) {
		//super();
		this.transactionDate = date;
		this.status = status;
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.savingsaccount = savingsaccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return transactionDate;
	}

	public void setDate(Date date) {
		this.transactionDate = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public SavingsAccount getSavingsaccount() {
		return savingsaccount;
	}

	public void setSavingsaccount(SavingsAccount savingsaccount) {
		this.savingsaccount = savingsaccount;
	}

	@Override
	public String toString() {
		return "SavingsTransaction [id=" + id + ", date=" + transactionDate + ", status=" + status + ", description=" + description
				+ ", type=" + type + ", amount=" + amount + ", availableBalance=" + availableBalance
				+ ", savingsaccount=" + savingsaccount + "]";
	}
	
	

}
