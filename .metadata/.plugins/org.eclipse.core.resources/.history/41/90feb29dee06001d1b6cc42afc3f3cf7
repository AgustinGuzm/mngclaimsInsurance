package com.hexa.model;

import java.util.Date;

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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dependent")
public class dependent {
	
	// Define fields to use in the table dependents
	@Id //primary key for  dependents id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto generate the value for id
	private Integer dependentId; //Id to identify the dependent
	
	//reference at parent table 
//	@ManyToOne //relationship many dependents to one customer
//	private customer customers;
	
	@ManyToOne //(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //relationship many dependents to one customer
	@JoinColumn(name = "customerId")
	private customer customers;
	
	private String  firstName; //dependent first name
	private String  middleName;//dependent middle name
	private String  lastName;//dependent last name
	private String  email;//dependent email address
	private String  phoneNumber;//dependent phone number
	private Boolean enrolled;// date when the dependent was enrolled in the system
	/**
	 * 
	 */
	public dependent() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dependentId
	 * @param customers
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param enrolled
	 */
	public dependent(Integer dependentId, customer customers, String firstName, String middleName, String lastName,
			String email, String phoneNumber, Boolean enrolled) {
		super();
		this.dependentId = dependentId;
		this.customers = customers;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enrolled = enrolled;
	}
	/**
	 * @return the dependentId
	 */
	public Integer getDependentId() {
		return dependentId;
	}
	/**
	 * @param dependentId the dependentId to set
	 */
	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the enrolled
	 */
	public Boolean getEnrolled() {
		return enrolled;
	}
	/**
	 * @param enrolled the enrolled to set
	 */
	public void setEnrolled(Boolean enrolled) {
		this.enrolled = enrolled;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((dependentId == null) ? 0 : dependentId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enrolled == null) ? 0 : enrolled.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		dependent other = (dependent) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (dependentId == null) {
			if (other.dependentId != null)
				return false;
		} else if (!dependentId.equals(other.dependentId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enrolled == null) {
			if (other.enrolled != null)
				return false;
		} else if (!enrolled.equals(other.enrolled))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "dependent [dependentId=" + dependentId + ", customers=" + customers + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", enrolled=" + enrolled + "]";
	}

	

}
