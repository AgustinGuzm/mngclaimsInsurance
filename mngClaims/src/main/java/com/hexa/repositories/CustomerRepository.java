package com.hexa.repositories;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hexa.model.customer;



public interface CustomerRepository extends JpaRepository<customer, Integer>{//CrudRepository<customer, Integer>{
	//public Integer countById(Integer customerId);
	
	@Query(value="select * from customer c where c.first_name like %:keyword%  or c.last_name like %:keyword% ", nativeQuery=true)
	List<customer> findByKeyword(@Param("keyword") String keyword);
	
		

}
