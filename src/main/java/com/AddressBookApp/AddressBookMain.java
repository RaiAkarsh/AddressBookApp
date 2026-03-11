package com.AddressBookApp;

import com.AddressBookApp.controller.AddressBookController;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBookController controller = new AddressBookController();
        controller.start();
    }
}