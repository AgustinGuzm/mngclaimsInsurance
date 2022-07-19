package com.hexa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexa.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

}
