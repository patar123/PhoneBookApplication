package com.ashokit.service;

import java.util.List;

import com.ashokit.model.Contact;

public interface ContactService {
	
	boolean saveContact(Contact c);
	
	List<Contact> getAllContacts( );
	
	Contact getContactById(Integer cid);
	
	boolean deleteContact(Integer cid);
	
	String findByMail(String email);
}
