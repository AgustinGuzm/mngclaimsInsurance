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
import com.hexa.model.dependent;
import com.hexa.repositories.CustomerRepository;
import com.hexa.repositories.DependentRepository;
import com.hexa.services.DependentService;

@Controller
public class DependentController {
	
	@Autowired 
	private DependentService service;
	
	@Autowired 
	private DependentRepository drepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@GetMapping("/dependent/new/{customerId}")
	public String AddNewDependent(@PathVariable("customerId") Integer customerId, Model model ) {
		
		model.addAttribute("dpndt", new dependent());
		Optional<customer> liscustomers = crepo.findById(customerId);
		model.addAttribute("liscustomers",liscustomers.get());
		model.addAttribute("cutomer_id", customerId);
		return "FrmAddDependent";
	}
	
	@PostMapping("/dependent/save")
	public String SaveDependent(dependent dpndt) {
		drepo.save(dpndt);
	
		//return "redirect:/dependent";
		return "redirect:/";
		
	}
	
	@GetMapping("/dependent/{customerId}")
	public String showDependentList(@PathVariable("customerId") Integer customerId, Model model) {
		//List<dependent> dpndt= service.ListAllDependent();
		List<dependent> dpndt= service.findBycustomerId(customerId);
		model.addAttribute("dpndt",dpndt);
		return "dependent";
	}
	
	@GetMapping("/dependent/edit/{dependentId}/{customerId}")
	public String updateDependent(@PathVariable("dependentId") Integer dependentId, Integer customerId, Model model) {
		dependent dpndt= drepo.findById(dependentId).get();
		model.addAttribute("dpndt", dpndt);
		List<customer> liscustomers = crepo.findAll();
		model.addAttribute("liscustomers",liscustomers);
		
		
		return "FrmAddDependent";
	}

}
