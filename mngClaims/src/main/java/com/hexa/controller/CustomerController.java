package com.hexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hexa.model.customer;
import com.hexa.services.CustomerNotFoundExecption;
import com.hexa.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired 
	private CustomerService service;
	
	@GetMapping("/customers")
	public String showCustomerList(Model model, String keyword) {
		List<customer> lstcstmrs; //= service.ListAllCustomer();
		if (keyword == null){
		lstcstmrs= service.ListAllCustomer();
		}
		else {
		lstcstmrs= service.findByKeyword(keyword);

		}
		       
		model.addAttribute("lstcstmrs",lstcstmrs);
		return "customers";
		
		
	}
	
	@GetMapping("/customers/new/{claimId}")
	public String AddNewCustomer(Model model) {
		model.addAttribute("cstmr", new customer());
		model.addAttribute("pageTitle", "Create a new customer");
		return "FrmAddCustomer";
		
	}
	
	@PostMapping("/customers/save")
	public String SaveCustomer(customer cstmr, RedirectAttributes ra) {
		service.SaveCustomer(cstmr);
		ra.addFlashAttribute("message", "The Customer has been saved successfully");
		return "redirect:/customers";
		
		
	}
	
	@GetMapping("/customers/edit/{customerId}")
	public String UpdateCustomer(@PathVariable("customerId") Integer customerId, Model model, RedirectAttributes ra) {
		try {
			customer cstmr= service.getCustomer(customerId);
			model.addAttribute("cstmr", cstmr);
			model.addAttribute("pageTitle", "Updating Customer..: " + customerId +"" );
			return "FrmAddCustomer";
		} catch (CustomerNotFoundExecption e){
			//ra.addAttribute("message", "Customer has Updated successfully");
			ra.addAttribute("message", e.getMessage());
			
			return "redirect:/customers";
			
		}
	}

	@GetMapping("/customers/delete/{customerId}")
	public String DeleteCustomer(@PathVariable("customerId") Integer customerId, RedirectAttributes ra) {
		try {
			service.deleteCustomer(customerId); 
			ra.addFlashAttribute("message", "Customer ID "+ customerId + " has been deleted successfully" );
		} catch (CustomerNotFoundExecption e){
			//ra.addAttribute("message", "Customer has deleted successfully");
			ra.addAttribute("message", e.getMessage());
		}
		return "redirect:/customers";
	}	
}
