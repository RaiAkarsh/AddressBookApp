package com.AddressBookApp.service;

import com.AddressBookApp.model.AddressBook;
import com.AddressBookApp.model.ContactPerson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressBookService {

    // UC6 – Store multiple AddressBooks
    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    private AddressBook currentAddressBook;

    // Create new AddressBook
    public void createAddressBook(String name) {

        if (addressBookMap.containsKey(name)) {
            System.out.println("AddressBook already exists!");
            return;
        }

        AddressBook newBook = new AddressBook();
        addressBookMap.put(name, newBook);
        currentAddressBook = newBook;

        System.out.println("AddressBook created: " + name);
    }

    // Switch AddressBook
    public void selectAddressBook(String name) {

        if (!addressBookMap.containsKey(name)) {
            System.out.println("AddressBook not found!");
            return;
        }

        currentAddressBook = addressBookMap.get(name);
        System.out.println("Switched to: " + name);
    }

    // UC2 – Add Contact
    public void addContact(ContactPerson person) {

        if (currentAddressBook == null) {
            System.out.println("Create or select AddressBook first!");
            return;
        }

        currentAddressBook.addContact(person);
        System.out.println("Contact Added Successfully");
    }

    // UC4 – Delete Contact
    public void deleteContact(String name) {

        if (currentAddressBook == null) return;

        ContactPerson toRemove = null;

        for (ContactPerson p : currentAddressBook.getContacts()) {
            if (p.getFirstName().equalsIgnoreCase(name)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            currentAddressBook.getContacts().remove(toRemove);
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    // Display contacts
    public void displayContacts() {

        if (currentAddressBook == null) return;

        for (ContactPerson p : currentAddressBook.getContacts()) {
            p.display();
            System.out.println("------------------");
        }
    }

    // Display all AddressBooks
    public void displayAddressBooks() {

        if (addressBookMap.isEmpty()) {
            System.out.println("No AddressBooks available");
            return;
        }

        for (String name : addressBookMap.keySet()) {
            System.out.println(name);
        }
    }
}