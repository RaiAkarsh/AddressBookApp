package com.AddressBookApp.controller;

import com.AddressBookApp.model.ContactPerson;
import com.AddressBookApp.service.AddressBookService;

import java.util.Scanner;

public class AddressBookController {

    AddressBookService service = new AddressBookService();

    public void addContact() {

        Scanner sc = new Scanner(System.in);

        ContactPerson person = new ContactPerson();

        System.out.print("Enter First Name: ");
        person.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        person.setLastName(sc.nextLine());

        System.out.print("Enter Address: ");
        person.setAddress(sc.nextLine());

        System.out.print("Enter City: ");
        person.setCity(sc.nextLine());

        System.out.print("Enter State: ");
        person.setState(sc.nextLine());

        System.out.print("Enter Zip: ");
        person.setZip(sc.nextLine());

        System.out.print("Enter Phone Number: ");
        person.setPhoneNumber(sc.nextLine());

        System.out.print("Enter Email: ");
        person.setEmail(sc.nextLine());

        service.addContact(person);

        System.out.println("\nContact Added Successfully\n");

        service.displayContacts();
    }
}