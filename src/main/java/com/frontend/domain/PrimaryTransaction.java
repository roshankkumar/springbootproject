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
 * Primary Transaction model class
 * 
 */

@Entity
public class PrimaryTransaction {
		
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
	    @JoinColumn(name = "primary_account_id")
		private PrimaryAccount primaryaccount;

		public PrimaryAccount getPrimaryaccount() {
			return primaryaccount;
		}

		public void setPrimaryaccount(PrimaryAccount primaryaccount) {
			this.primaryaccount = primaryaccount;
		}

		public PrimaryTransaction() {
			
			// TODO Auto-generated constructor stub
		}

		public PrimaryTransaction(Date date, String status, String description, String type, Double amount,
				BigDecimal availableBalance) {
			//super();
			
			this.transactionDate = date;
			this.status = status;
			this.description = description;
			this.type = type;
			this.amount = amount;
			this.availableBalance = availableBalance;
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

		@Override
		public String toString() {
			return "PrimaryTransaction [id=" + id + ", date=" + transactionDate + ", status=" + status + ", description="
					+ description + ", type=" + type + ", amount=" + amount + ", availableBalance=" + availableBalance
					+ ", primaryaccount=" + primaryaccount + "]";
		}	
		
		
}
