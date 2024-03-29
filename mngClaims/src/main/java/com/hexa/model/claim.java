package com.hexa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "claim")
public class claim {

	// Define fields to use in the table dependents
	@Id //primary key for  dependents id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto generate the value for id
	private Integer claimId; //Id to identify the dependent
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL) //relationship many claims to one customer
	@JoinColumn(name = "customerId")
	private customer customers;
	private String  ClaimDescription; //dependent first name
	private Boolean claimActive;// determine if the claim is active or discarded
	/**
	 * 
	 */
	public claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param claimId
	 * @param customers
	 * @param claimDescription
	 * @param claimActive
	 */
	public claim(Integer claimId, customer customers, String claimDescription, Boolean claimActive) {
		super();
		this.claimId = claimId;
		this.customers = customers;
		ClaimDescription = claimDescription;
		this.claimActive = claimActive;
	}
	/**
	 * @return the claimId
	 */
	public Integer getClaimId() {
		return claimId;
	}
	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}
	/**
	 * @return the customers
	 */
	public customer getCustomers() {
		return customers;
	}
	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(customer customers) {
		this.customers = customers;
	}
	/**
	 * @return the claimDescription
	 */
	public String getClaimDescription() {
		return ClaimDescription;
	}
	/**
	 * @param claimDescription the claimDescription to set
	 */
	public void setClaimDescription(String claimDescription) {
		ClaimDescription = claimDescription;
	}
	/**
	 * @return the claimActive
	 */
	public Boolean getClaimActive() {
		return claimActive;
	}
	/**
	 * @param claimActive the claimActive to set
	 */
	public void setClaimActive(Boolean claimActive) {
		this.claimActive = claimActive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ClaimDescription == null) ? 0 : ClaimDescription.hashCode());
		result = prime * result + ((claimActive == null) ? 0 : claimActive.hashCode());
		result = prime * result + ((claimId == null) ? 0 : claimId.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		claim other = (claim) obj;
		if (ClaimDescription == null) {
			if (other.ClaimDescription != null)
				return false;
		} else if (!ClaimDescription.equals(other.ClaimDescription))
			return false;
		if (claimActive == null) {
			if (other.claimActive != null)
				return false;
		} else if (!claimActive.equals(other.claimActive))
			return false;
		if (claimId == null) {
			if (other.claimId != null)
				return false;
		} else if (!claimId.equals(other.claimId))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "claim [claimId=" + claimId + ", customers=" + customers + ", ClaimDescription=" + ClaimDescription
				+ ", claimActive=" + claimActive + "]";
	}
	
		
	
}
