package com.mjn.contactsbook.repository;

import com.mjn.contactsbook.model.Contact;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.mjn.contactsbook.prototype.ContactsPrototype.aContact;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void findByName() {
        contactRepository.save(aContact());
        Contact test = new Contact();
        test.setName(aContact().getName());
        test.setSurname(aContact().getSurname());
        test.setEmail(aContact().getEmail());
        test.setNumber(aContact().getNumber());
        List<Contact> contacts = contactRepository.findByName(test.getName());

        assertThat(contacts).isNotNull();
        assertThat(test.getName()).isEqualTo(aContact().getName());
        assertThat(test.getSurname()).isEqualTo(aContact().getSurname());
        assertThat(test.getEmail()).isEqualTo(aContact().getEmail());
        assertThat(test.getNumber()).isEqualTo(aContact().getNumber());


    }
}