package com.AddressBookApp;

import com.AddressBookApp.model.ContactPerson;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        ContactPerson person = new ContactPerson(
                "Akarsh",
                "Rai",
                "Delhi Road",
                "Agra",
                "UP",
                "282002",
                "9876543210",
                "akarsh@gmail.com"
        );

        //person.display();
    }
}