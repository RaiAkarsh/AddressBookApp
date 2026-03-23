package com.AddressBookApp.service;

import com.AddressBookApp.model.AddressBook;
import com.AddressBookApp.model.ContactPerson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressBookService {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    private AddressBook currentAddressBook;

    public String createAddressBook(String name) {
        if (addressBookMap.containsKey(name)) {
            return "AddressBook already exists!";
        }
        AddressBook newBook = new AddressBook();
        addressBookMap.put(name, newBook);
        currentAddressBook = newBook;
        return "AddressBook created: " + name;
    }

    public String selectAddressBook(String name) {
        if (!addressBookMap.containsKey(name)) {
            return "AddressBook not found!";
        }
        currentAddressBook = addressBookMap.get(name);
        return "Switched to: " + name;
    }

    public String addContact(ContactPerson person) {
        if (currentAddressBook == null) {
            return "Create or select AddressBook first!";
        }
        currentAddressBook.addContact(person);
        return "Contact Added Successfully";
    }

    public String editContact(String name, ContactPerson updatedPerson) {

        if (currentAddressBook == null) {
            return "No AddressBook selected!";
        }
        for (ContactPerson p : currentAddressBook.getContacts()) {
            if (p.getFirstName().equalsIgnoreCase(name)) {
                p.setLastName(updatedPerson.getLastName());
                p.setAddress(updatedPerson.getAddress());
                p.setCity(updatedPerson.getCity());
                p.setState(updatedPerson.getState());
                p.setZip(updatedPerson.getZip());
                p.setPhoneNumber(updatedPerson.getPhoneNumber());
                p.setEmail(updatedPerson.getEmail());

                return "Contact Updated Successfully";
            }
        }

        return "Contact Not Found";
    }

    public String deleteContact(String name) {

        if (currentAddressBook == null) {
            return "No AddressBook selected!";
        }

        ContactPerson toRemove = null;

        for (ContactPerson p : currentAddressBook.getContacts()) {
            if (p.getFirstName().equalsIgnoreCase(name)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            currentAddressBook.getContacts().remove(toRemove);
            return "Contact Deleted";
        }

        return "Contact Not Found";
    }

    public Object displayContacts() {
        if (currentAddressBook == null) {
            return "No AddressBook selected!";
        }
        return currentAddressBook.getContacts();
    }

    public Object displayAddressBooks() {
        return addressBookMap.keySet();
    }
}