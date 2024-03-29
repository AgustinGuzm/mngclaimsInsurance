package com.hexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hexa.model.customer;
import com.hexa.model.claim;
import com.hexa.repositories.CustomerRepository;
import com.hexa.repositories.ClaimRepository;
import com.hexa.services.ClaimService;

@Controller
public class claimController {
	
	@Autowired 
	private ClaimService service;
	
	@Autowired 
	private ClaimRepository drepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@GetMapping("/claim/new/{customerId}")
	public String AddNewDependent(@PathVariable("customerId") Integer customerId, Model model ) {
		
		model.addAttribute("dpndt", new claim());
		Optional<customer> liscustomers = crepo.findById(customerId);
		model.addAttribute("liscustomers",liscustomers.get());
		model.addAttribute("cutomer_id", customerId);
		return "FrmAddClaim";
	}
	
	@PostMapping("/claim/save")
	public String SaveDependent(claim dpndt) {
		drepo.save(dpndt);
	
		//return "redirect:/dependent";
		return "redirect:/";
		
	}
	
	@GetMapping("/claim/{customerId}")
	public String showDependentList(@PathVariable("customerId") Integer customerId, Model model) {
		//List<dependent> dpndt= service.ListAllDependent();
		List<claim> dpndt= service.findBycustomerId(customerId);
		model.addAttribute("dpndt",dpndt);
		return "claim";
	}
	
	@GetMapping("/claim/edit/{claimId}/{customerId}")
	public String updateDependent(@PathVariable("claimId") Integer claimId, Integer customerId, Model model) {
		claim dpndt= drepo.findById(claimId).get();
		model.addAttribute("dpndt", dpndt);
		List<customer> liscustomers = crepo.findAll();
		model.addAttribute("liscustomers",liscustomers);
		
		
		return "FrmAddClaim";
	}
	
//	@PostMapping("/upload")
//	 public String fileUpload(@RequestParam("file") MultipartFile file,  Model model) 
//			 throws IOException {
//		 Student student = new Student();
//		  String fileName = file.getOriginalFilename();
//		  student.setProfilePicture(fileName);
//		  student.setContent(file.getBytes());
//		  student.setSize(file.getSize());
//		  service.createStudent(student);
//		  model.addAttribute("success", "File Uploaded Successfully!!!");
//		  return "index";
//	  
//	 }
//	 
//	 
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
//	 
//	 @GetMapping("/image")
//	 public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Student> student)
//	   throws ServletException, IOException {
//	  
//	  student = service.findStudentById(id);
//	  response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
//	  response.getOutputStream().write(student.get().getContent());
//	  response.getOutputStream().close();
//	 }
	
	

}
