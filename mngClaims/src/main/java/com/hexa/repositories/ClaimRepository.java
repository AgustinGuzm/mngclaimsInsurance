package com.hexa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.hexa.model.claim;

public interface ClaimRepository extends JpaRepository<claim, Integer>{
	
	@Query(value="select * from claim c where c.customer_id =:keyword ", nativeQuery=true)
	List<claim> findBycustomerId(@Param("keyword") Integer customerId);

}
