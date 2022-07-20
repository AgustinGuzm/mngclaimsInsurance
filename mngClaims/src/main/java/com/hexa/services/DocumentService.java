package com.hexa.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.hexa.model.Document;
import com.hexa.model.claim;
import com.hexa.repositories.ClaimRepository;
import com.hexa.repositories.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repo;
	@Autowired
	private ClaimRepository clarepo;

	public void Uploadfile( MultipartFile multipartFile, Document docs, Integer claimId, Model model) {
		
//		claim Claim = new  claim();
//		Claim.setClaimId(claimId);
//		docs.setClaims(Claim);
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
//		Document savedoc = repo.save(docs);
//		claim Claim= clarepo.findById(claimId).get();
//		savedoc.setClaims(Claim);
//		repo.save(savedoc);
	}
//throws CustomerNotFoundExecption
	public List<Document> ListDocsByClaimId(Integer claimId) {
		List<Document> result= repo.findByClaimId(claimId);
//		if(result.isPresent()) {
//			return Optional.of(result.get());
//		}else {
//			return Optional.empty();//Optional.empty();
//			//return Optional.ofNullable(result.get());
//		}
		return result;
		
	}
	
	public List<Document> findAllDocuments(){
		List<Document> lstdocs = repo.findAll();
		return lstdocs;
	}

	public void download(Integer documentId, HttpServletResponse response, Model model) throws Exception   {
		
		Optional<Document> result = repo.findById(documentId);
		
		if(!result.isPresent()) {
			throw new Exception("Could not find document");
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
//	 @GetMapping("/downloadfile")
//	 public void downloadFile(@Param("id") Long id , Model model, HttpServletResponse response) 
//			 throws IOException {
//		  Optional<Student> temp = service.findStudentById(id);
//		  if(temp!=null) {
//		   Student student = temp.get();
//		   response.setContentType("application/octet-stream");
//		   String headerKey = "Content-Disposition";
//		   String headerValue = "attachment; filename = "+student.getProfilePicture();
//		   response.setHeader(headerKey, headerValue);
//		   ServletOutputStream outputStream = response.getOutputStream();
//		   outputStream.write(student.getContent());
//		   outputStream.close();
//		  }
//	 }
	
	
	
	
}
