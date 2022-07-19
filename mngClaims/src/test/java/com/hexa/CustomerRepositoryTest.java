package com.hexa;


import java.util.Optional;

import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hexa.repositories.CustomerRepository;

import com.hexa.model.customer;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository repo;
	
//	@Test
//	public void Testaddcustomer() {
//		customer ctmr = new customer();
//		
//		ctmr.setFirstName("julia");
//		ctmr.setLastName("Ramirez");
//		ctmr.setEmail("julia@yahoo.com");
//		ctmr.setPhoneNumber("33323456789");
//		ctmr.setAddress("123 abc");
//		ctmr.setCityAddress("springfield");
//		ctmr.setStateAddress("DC");
//		ctmr.setZipcodeAddress("12345000");
//		
//		customer savectmr = repo.save(ctmr);
//		Assertions.assertThat(savectmr).isNotNull();
//		Assertions.assertThat(savectmr.getCustomerId()).isGreaterThan(0);
//	}
		
	@Test
	public void TestListAllCustomer() {	
		Iterable<customer> lcust= repo.findAll();
		Assertions.assertThat(lcust).hasSizeGreaterThan(0);
	}
	
//	@Test
//	public void TestupdateCustomer() {
//		Integer cID = 1;
//		String chName= "Augusto the Lord";
//		Optional<customer> uptcstmr= repo.findById(cID);
//		customer ctm = uptcstmr.get();
//		ctm.setFirstName(chName);
//		repo.save(ctm);
//		
//		customer udpcustomer = repo.findById(cID).get();
//		Assertions.assertThat(udpcustomer.getFirstName()).isEqualTo(chName);		
//	}
//	@Test
//	public void Testgetcustomer() {
//		Integer cID = 1;
//		Optional<customer> getcstmr= repo.findById(cID);
//		Assertions.assertThat(getcstmr).isPresent();
//	}
	
//	@Test
//	public void Testdeletecustomer() {
//		Integer cID = 5;
//		repo.deleteById(cID);
//		Optional<customer> delcstmr= repo.findById(cID);
//		Assertions.assertThat(delcstmr).isNotPresent();
//		
//	}
}
