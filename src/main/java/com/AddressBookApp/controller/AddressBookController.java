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

        while (true) {

            System.out.println("\n1 Create AddressBook");
            System.out.println("2 Select AddressBook");
            System.out.println("3 Add Contact");
            System.out.println("4 Display Contacts");
            System.out.println("5 Show AddressBooks");
            System.out.println("6 Exit");
            System.out.println("Enter choice");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter AddressBook Name: ");
                    service.createAddressBook(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter AddressBook Name: ");
                    service.selectAddressBook(sc.nextLine());
                    break;

                case 3:

                    ContactPerson person = new ContactPerson();

                    System.out.print("First Name: ");
                    person.setFirstName(sc.nextLine());

                    System.out.print("Last Name: ");
                    person.setLastName(sc.nextLine());

                    System.out.print("City: ");
                    person.setCity(sc.nextLine());

                    service.addContact(person);
                    break;

                case 4:
                    service.displayContacts();
                    break;

                case 5:
                    service.displayAddressBooks();
                    break;

                case 6:
                	System.out.println("Exiting...");
                    return;
            }
        }
    }
}