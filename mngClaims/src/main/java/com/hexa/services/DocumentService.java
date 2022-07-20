package com.hexa.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.hexa.model.Document;
import com.hexa.model.claim;
import com.hexa.repositories.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repo;

	public void Uploadfile( MultipartFile multipartFile, Document docs, Integer claimId) {
		
		//System.out.println(docs.getClaims().getClaimId());
		
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

	public Optional<Document> ListDocsByClaimId(Integer claimId) throws CustomerNotFoundExecption																							{
		Optional<Document> result= repo.findById(claimId);
		if(result.isPresent()) {
			return Optional.of(result.get());
		}
		throw new CustomerNotFoundExecption("No document with claimId "+claimId+"was found");
		
	}
	
	public List<Document> findAllDocuments(){
		List<Document> lstdocs = repo.findAll();
		return lstdocs;
	}

	public void download(Integer documentId, HttpServletResponse response) throws CustomerNotFoundExecption, IOException  {
		
		Optional<Document> result = repo.findById(documentId);
		
		if(!result.isPresent()) {
			throw new CustomerNotFoundExecption("Could not find document");
		}
		
		Document document = result.get();
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue ="attachment; filename=" + document.getDocumentName();
	
			response.setHeader(headerKey, headerValue);
			
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(document.getContent());
			outputStream.close();



	}
	
}
