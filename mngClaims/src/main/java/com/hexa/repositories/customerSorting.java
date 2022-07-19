package com.hexa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hexa.model.customer;

public interface customerSorting extends PagingAndSortingRepository<customer, Integer>{

//	@Query(value="select * from customer c where c.first_name like %:keyword%  or c.last_name like %:keyword% ", nativeQuery=true)
//	List<customer> findByKeyword(@Param("keyword") String keyword);
}
