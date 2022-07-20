package com.hexa.controller;


import java.io.IOException;
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
import com.hexa.services.CustomerNotFoundExecption;
import com.hexa.services.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentservice;
	
	@GetMapping("/Documents")
	public String showClaimList(Model model) {
		List<Document> 	 lstdocs= documentservice.findAllDocuments();
		model.addAttribute("lstdocs",lstdocs);
		return  "Documents";
	}
	
	
	@GetMapping("/Documents/new/{claimId}")
	public String uploadDocuments(@PathVariable("claimId") Integer claimId, Model model) throws CustomerNotFoundExecption{
		Optional<Document> lstdocs;
		model.addAttribute("docs", new Document());
		lstdocs = documentservice.ListDocsByClaimId(claimId);
		model.addAttribute("lstdocs",lstdocs.get());
		model.addAttribute("claim_id", claimId);
		model.addAttribute("pageTitle", "Upload a new File");
		
		return "Documents";
	}
	@PostMapping("/Document/save/{claimId}")
	public String SaveDocument( @RequestParam("document") MultipartFile multipartFile, @RequestParam("claimId") Integer claimId,Document docs, RedirectAttributes ra) {
		documentservice.Uploadfile( multipartFile, docs, claimId);
		ra.addFlashAttribute("message", "The File has been upload successfully");
		return "redirect:/customers";
	}
	
	
	@GetMapping("/download")
	public void downloadFile(@Param("documentId") Integer documentId, HttpServletResponse response) throws CustomerNotFoundExecption, IOException {
		

			documentservice.download(documentId, response);

		
		
		
	}
	
}
