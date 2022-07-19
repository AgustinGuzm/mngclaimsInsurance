package com.hexa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.hexa.model.customer;
import com.hexa.repositories.CustomerRepository;
import com.hexa.repositories.customerSorting;

@Service
public class CustomerService {
	
	@Autowired 
	private CustomerRepository repo;
	//private customerSorting repo;
	public List<customer> ListAllCustomer(){
                 
		return repo.findAll();
	}
	
	public void SaveCustomer(customer cstmr) {
		repo.save(cstmr);
	}
	
	public customer getCustomer(Integer customerId) throws CustomerNotFoundExecption{
		Optional<customer> result= repo.findById(customerId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new CustomerNotFoundExecption("No customer with ID "+customerId+"was found");

	}
	
	public void deleteCustomer(Integer customerId) throws CustomerNotFoundExecption{
//		Integer ncstmrs =repo.countById(customerId);
//		if (ncstmrs == null || ncstmrs == 0) {
//			throw new CustomerNotFoundExecption("No customer with ID "+customerId+" was found");
//		}
//		repo.deleteById(customerId);
		Optional<customer> result= repo.findById(customerId);
		if(result.isEmpty()) {
			throw new CustomerNotFoundExecption("No customer with ID "+customerId+"was found");
		}
		repo.deleteById(customerId);
	}
	
	//Filter customer by keyword over fisrt name and last name.
	public List<customer> findByKeyword(@Param("keyword") String keyword){
		
		return repo.findByKeyword(keyword);
		
	}

}
