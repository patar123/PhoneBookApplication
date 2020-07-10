package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.model.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/editContact")
	String editContact(@RequestParam("cid")Integer contactId ,Model model) {
		Contact contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);
		return "contactInfo";
	}
	
	String updateContact(Contact c, Model model) {
		return "";
	}
	
	@GetMapping("/deleteContact")
	String deleteContact(@RequestParam("cid")Integer contactId,Model model) {
		boolean isDeleted = contactService.deleteContact(contactId);
		if (isDeleted) {
			return "redirect:/viewContact";
		}
		return null;
	}
}
