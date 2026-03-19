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
            System.out.println("4 Edit Contact");
            System.out.println("5 Delete Contact");
            System.out.println("6 Display Contacts");
            System.out.println("7 Show AddressBooks");
            System.out.println("8 Exit");
            System.out.print("Enter choice: ");

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

                case 4:
                    System.out.print("Enter First Name to Edit: ");
                    String editName = sc.nextLine();

                    ContactPerson updated = new ContactPerson();

                    System.out.print("Enter new Last Name: ");
                    updated.setLastName(sc.nextLine());

                    System.out.print("Enter new Address: ");
                    updated.setAddress(sc.nextLine());

                    System.out.print("Enter new City: ");
                    updated.setCity(sc.nextLine());

                    System.out.print("Enter new State: ");
                    updated.setState(sc.nextLine());

                    System.out.print("Enter new Zip: ");
                    updated.setZip(sc.nextLine());

                    System.out.print("Enter new Phone: ");
                    updated.setPhoneNumber(sc.nextLine());

                    System.out.print("Enter new Email: ");
                    updated.setEmail(sc.nextLine());

                    service.editContact(editName, updated);
                    break;

                case 5:
                    System.out.print("Enter First Name to Delete: ");
                    String deleteName = sc.nextLine();

                    service.deleteContact(deleteName);
                    break;

                case 6:
                    service.displayContacts();
                    break;

                case 7:
                    service.displayAddressBooks();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}