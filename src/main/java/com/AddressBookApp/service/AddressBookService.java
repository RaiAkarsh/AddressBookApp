package com.AddressBookApp.service;

import com.AddressBookApp.model.AddressBook;
import com.AddressBookApp.model.ContactPerson;

import java.util.Scanner;

public class AddressBookService {

    AddressBook addressBook = new AddressBook();

    public void addContact(ContactPerson person) {
        addressBook.getContacts().add(person);
    }

    public void displayContacts() {

        for (ContactPerson person : addressBook.getContacts()) {
            person.display();
            System.out.println("--------------------");
        }
    }

    public void editContact(String firstName) {

        Scanner sc = new Scanner(System.in);

        for (ContactPerson person : addressBook.getContacts()) {

            if (person.getFirstName().equalsIgnoreCase(firstName)) {

                System.out.println("\nSelect field to update:");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip");
                System.out.println("5. Phone Number");
                System.out.println("6. Email");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter new Address: ");
                        person.setAddress(sc.nextLine());
                        break;

                    case 2:
                        System.out.print("Enter new City: ");
                        person.setCity(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter new State: ");
                        person.setState(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter new Zip: ");
                        person.setZip(sc.nextLine());
                        break;

                    case 5:
                        System.out.print("Enter new Phone Number: ");
                        person.setPhoneNumber(sc.nextLine());
                        break;

                    case 6:
                        System.out.print("Enter new Email: ");
                        person.setEmail(sc.nextLine());
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

                System.out.println("\nContact Updated Successfully\n");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }
}