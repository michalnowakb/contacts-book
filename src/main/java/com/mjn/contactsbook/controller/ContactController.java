package com.mjn.contactsbook.controller;


import com.mjn.contactsbook.model.Contact;
import com.mjn.contactsbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts(@RequestParam(required = false) String name) {
        try {
            List<Contact> contacts = new ArrayList<Contact>();

            if (name == null)
                contactRepository.findAll().forEach(contacts::add);
            else
                contactRepository.findByName(name).forEach(contacts::add);

            if (contacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("contacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) {
        Optional<Contact> contactData = contactRepository.findById(id);

        if (contactData.isPresent()) {
            return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        try {
            Contact _contact = contactRepository
                    .save(new Contact(contact.getName(), contact.getSurname(), contact.getEmail(), contact.getNumber()));
            return new ResponseEntity<>(_contact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
