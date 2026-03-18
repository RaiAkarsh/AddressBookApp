package com.AddressBookApp.service;

import com.AddressBookApp.model.AddressBook;
import com.AddressBookApp.model.ContactPerson;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    AddressBook addressBook = new AddressBook();

    // UC2 – Add Contact
    public void addContact(ContactPerson person) {
        addressBook.addContact(person);
        System.out.println("Contact Added Successfully");
    }

    // UC3 – Edit Contact
    public void editContact(String name, String newCity) {

        for (ContactPerson person : addressBook.getContacts()) {
            if (person.getFirstName().equalsIgnoreCase(name)) {
                person.setCity(newCity);
                System.out.println("Contact Updated");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    // UC4 – Delete Contact
    public void deleteContact(String name) {

        ContactPerson toRemove = null;

        for (ContactPerson person : addressBook.getContacts()) {
            if (person.getFirstName().equalsIgnoreCase(name)) {
                toRemove = person;
                break;
            }
        }

        if (toRemove != null) {
            addressBook.getContacts().remove(toRemove);
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    // UC5 – Display Multiple Contacts
    public void displayContacts() {

        if (addressBook.getContacts().isEmpty()) {
            System.out.println("No Contacts Found");
            return;
        }

        for (ContactPerson person : addressBook.getContacts()) {
            person.display();
            System.out.println("----------------------");
        }
    }
}