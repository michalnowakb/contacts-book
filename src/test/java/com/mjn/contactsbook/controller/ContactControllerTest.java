package com.mjn.contactsbook.controller;

import com.mjn.contactsbook.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.mjn.contactsbook.prototype.ContactsPrototype.aContact;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ContactControllerTest {

    @Autowired
    private ContactRepository contactRepository;

    @BeforeEach
    void setUp(){
        contactRepository = mock(ContactRepository.class);

    }

    @Test
    void getAllContacts() {
    }

    @Test
    void getContactById() {
    }

    @Test
    void createContact() {
        when(contactRepository.save(any())).thenReturn(aContact());
    }

    @Test
    void updateContact() {
    }

    @Test
    void deleteContactById() {
    }
}