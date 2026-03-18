package com.AddressBookApp.controller;

import com.AddressBookApp.model.ContactPerson;
import com.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookService service;

    Scanner sc = new Scanner(System.in);
    
    public void start() {
    	System.out.println("Wellcome to the AddressBook");
        while (true) {

            System.out.println("\n1 Add Contact");
            System.out.println("2 Edit Contact");
            System.out.println("3 Delete Contact");
            System.out.println("4 Display Contacts");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    ContactPerson person = new ContactPerson();

                    System.out.print("First Name: ");
                    person.setFirstName(sc.nextLine());

                    System.out.print("Last Name: ");
                    person.setLastName(sc.nextLine());

                    System.out.print("Address: ");
                    person.setAddress(sc.nextLine());

                    System.out.print("City: ");
                    person.setCity(sc.nextLine());

                    System.out.print("State: ");
                    person.setState(sc.nextLine());

                    System.out.print("Zip: ");
                    person.setZip(sc.nextLine());

                    System.out.print("Phone: ");
                    person.setPhoneNumber(sc.nextLine());

                    System.out.print("Email: ");
                    person.setEmail(sc.nextLine());

                    service.addContact(person);
                    break;

                case 2:

                    System.out.print("Enter name to edit: ");
                    String editName = sc.nextLine();

                    System.out.print("Enter new city: ");
                    String newCity = sc.nextLine();

                    service.editContact(editName, newCity);
                    break;

                case 3:

                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();

                    service.deleteContact(deleteName);
                    break;

                case 4:

                    service.displayContacts();
                    break;

                case 5:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}