package com.hexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hexa.model.Document;
import com.hexa.services.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService docser;
	
	@GetMapping("/Documents/new/{claimId}")
	public String uploadDocuments(@PathVariable("claimId") Integer claimId, Model model){
		
		model.addAttribute("docs", new Document());
		model.addAttribute("pageTitle", "Upload a new File");
		
		return "Documents";
	}
	@PostMapping("/Document/save")
	public String SaveDocument(@RequestParam("document") MultipartFile multipartFile,Document docs, RedirectAttributes ra) {
		docser.Uploadfile(multipartFile, docs);
		ra.addFlashAttribute("message", "The File has been upload successfully");
		return "redirect:/customers";
	}
}
