package com.hexa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hexa.model.claim;
//import com.hexa.model.customer;

//import com.hexa.repositories.CustomerR;
import com.hexa.repositories.ClaimRepository;

@Service
public class ClaimService {
	
	@Autowired private ClaimRepository repo;
	
	public List<claim> ListAllDependent(){
		return repo.findAll();
	}
	public List<claim> findBycustomerId(@Param("customerId") Integer customerId){
		return repo.findBycustomerId(customerId);
	}
}
