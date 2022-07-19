package com.hexa.services;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hexa.model.Document;
import com.hexa.repositories.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repo;

	public void Uploadfile(MultipartFile multipartFile, Document docs) {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		docs.setDocumentName(fileName);
		
		try {
			docs.setContent(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		docs.setDocumentSize(multipartFile.getSize());;
		docs.setUploadTime(new Date());
		repo.save(docs);
		
		
	}
	
}
