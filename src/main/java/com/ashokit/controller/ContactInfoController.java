package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.model.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactservice;
	
	@GetMapping(value = {"/","/addContact"})
	String loadForm(Model model) {
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		return "contactInfo";
	}
	
	@PostMapping("/saveContact")
	String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes attribute) {
		boolean isSaved = contactservice.saveContact(c);
		if (isSaved) {
			attribute.addFlashAttribute("sucMsg", "Contact Saved");
		}else {
			attribute.addFlashAttribute("errMsg", "Failed to Save Contact");
		}
		return "redirect:/addContact";
	}
	
	@GetMapping("/viewContact")
	String handleViewContactsLink(Model model) {
		List<Contact> list= contactservice.getAllContacts();
		model.addAttribute("list", list);
		return "viewContacts";
	}
}
