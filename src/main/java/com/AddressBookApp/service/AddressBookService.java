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

    public void selectAddressBook(String name) {

        if (!addressBookMap.containsKey(name)) {
            System.out.println("AddressBook not found!");
            return;
        }

        currentAddressBook = addressBookMap.get(name);
        System.out.println("Switched to: " + name);
    }

    public void addContact(ContactPerson person) {

        if (currentAddressBook == null) {
            System.out.println("Create or select AddressBook first!");
            return;
        }

        currentAddressBook.addContact(person);
        System.out.println("Contact Added Successfully");
    }

    public void editContact(String name, ContactPerson updatedPerson) {

        if (currentAddressBook == null) {
            System.out.println("No AddressBook selected!");
            return;
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

                System.out.println("Contact Updated Successfully");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    public void deleteContact(String name) {

        if (currentAddressBook == null) {
            System.out.println("No AddressBook selected!");
            return;
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
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    public void displayContacts() {

        if (currentAddressBook == null) {
            System.out.println("No AddressBook selected!");
            return;
        }

        if (currentAddressBook.getContacts().isEmpty()) {
            System.out.println("No Contacts Found");
            return;
        }

        for (ContactPerson p : currentAddressBook.getContacts()) {
            p.display();
            System.out.println("------------------");
        }
    }

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