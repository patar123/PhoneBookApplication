package com.ashokit.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.contactEntity.ContactEntity;
import com.ashokit.model.Contact;
import com.ashokit.repo.ContactRepository;
import com.ashokit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();

		BeanUtils.copyProperties(c, entity);

		ContactEntity savedEntity = contactRepo.save(entity);

		return savedEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();

		List<ContactEntity> entityList = contactRepo.findAll();
		
		entityList.forEach(entity ->{
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contacts.add(c);
		});
		return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById = contactRepo.findById(cid);
		if (findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

	@Override
	public String findByMail(String email) {
		ContactEntity entity = contactRepo.findByContactEmail(email);
		if (entity!=null) {
			return "Duplicate";
		}else {
			return "Unique";
		}
	}
}
