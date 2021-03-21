package com.mjn.contactsbook.repository;

import com.mjn.contactsbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
//    List<Contact> findContactContaining(String name);
      List<Contact> findByName(String name);
}
