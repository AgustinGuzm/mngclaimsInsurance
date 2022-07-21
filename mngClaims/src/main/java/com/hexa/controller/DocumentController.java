package com.hexa.controller;


//import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hexa.model.Document;
import com.hexa.model.claim;
import com.hexa.repositories.ClaimRepository;
//import com.hexa.model.claim;
import com.hexa.services.CustomerNotFoundExecption;
import com.hexa.services.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentservice;
	@Autowired
	private ClaimRepository crepo;
	
	@GetMapping("/Documents")
	public String showClaimList(Model model) {
		List<Document> 	 lstdocs= documentservice.findAllDocuments();
		model.addAttribute("lstdocs",lstdocs);
		return  "Documents";
	}
	
	
	@GetMapping("/Documents/new/{claimId}")
	public String uploadDocuments(@PathVariable("claimId") Integer claimId, Model model){
		
		model.addAttribute("docs", new Document());
		
		Optional<Document> 	lsdoc= documentservice.findAllDocuments()
				                    .stream()
				                    .findFirst();
		
		List<Document> lstdocs = documentservice.ListDocsByClaimId(claimId);
		List<claim> lstclaims = crepo.findAll();  
		model.addAttribute("lstdocs",lstdocs);
		model.addAttribute("lstdoc",lsdoc);
		model.addAttribute("lstclaims", lstclaims);
		
		model.addAttribute("claminId", claimId);
		model.addAttribute("pageTitle", "Upload a new File");
		
		return "Documents";
	}
	@PostMapping("/Document/save/{claimId}")
	public String SaveDocument( @RequestParam("document") MultipartFile multipartFile, @PathVariable("claimId") Integer claimId,Document docs, RedirectAttributes ra, Model model) {
		System.out.println("THE CLAIM ID IS..." + claimId);
		documentservice.Uploadfile( multipartFile, docs, claimId, model);
		ra.addFlashAttribute("message", "The File has been upload successfully");
		return "redirect:/customers";
	}
	
    //@Param("documentId") Integer documentId
	@GetMapping("/download/{documentId}")
	public void downloadFile(@PathVariable("documentId") Integer documentId, HttpServletResponse response, Model model) throws Exception  {
		
	
			documentservice.download(documentId, response, model);
	
	}
	
}
