package com.mjn.contactsbook.prototype;

import com.mjn.contactsbook.model.Contact;

public class ContactsPrototype {

    public static Contact aContact(){
        Contact contact = new Contact();
        contact.setName("David");
        contact.setSurname("Smith");
        contact.setEmail("dsmith@email.com");
        contact.setNumber("8756781231");
        return contact;
    }
}
