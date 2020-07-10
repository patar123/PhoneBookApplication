package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.contactEntity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}
