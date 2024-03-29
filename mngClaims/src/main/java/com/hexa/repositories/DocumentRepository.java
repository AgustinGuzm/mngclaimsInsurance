package com.hexa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexa.model.Document;


public interface DocumentRepository extends JpaRepository<Document, Integer>{

//	@Query(value="select * from documents ", nativeQuery=true)
//	List<Document> findAll();
	
	@Query(value="select * from documents d where d.claim_id =:keyword ", nativeQuery=true)
	List<Document> findByClaimId(@Param("keyword") Integer claimId);

	@Query(value="SELECT  distinct  d.document_id,  d.claim_id,  d.document_name,  d.document_size, d.upload_time FROM hexa_insurance.documents d where d.claim_id =:keyword ", nativeQuery=true)
	Optional<Document> OptDocsByClaimId(@Param("keyword") Integer claimId);
	
}
