/**
 *
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 07.06.21
 *
 * purpose: Managing user address book,user can add delete edit and show person
 * details.
 *
 */

package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.Model.PersonInfo; // importing person or user model from model package.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    //creating array list for storing person details
    List<PersonInfo> personList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method from here welcome message is displayed
     *
     */
    public static void main(String[] args) {
        // creating object of a addressbook class

        AddressBook addressbook = new AddressBook();
        System.out.println("Welcome to Address Book Program");

        boolean isExit = false;
        while (!isExit) {

            System.out.println("Enter options\n1.Add\n2.Edit\n3.Delete\n4.show contacts\n5.Exit");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    addressbook.addPerson();
                    break;
                case 2:
                    addressbook.editUser();
                    break;
                case 3:
                    addressbook.deleteUser();
                    break;
                case 4:
                    addressbook.showContacts();
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        } // end of while loop
    }
}