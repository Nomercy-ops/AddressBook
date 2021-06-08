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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {

    //creating array list for storing person details
    public int indexValue = 1;
    public HashMap<Integer, PersonInfo> personList = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method from here welcome message is display.
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

                    addressbook.addContact();

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

    /**
     * uc2- getting input from user and adding it to the addressbook. for
     * storing the input arrayList has been used. all the person details is
     * stored in a person list arraylist. Added option to add more contacts or
     * not.
     */
    private void addContact() {
        int userChoice = 1;
        while (userChoice != 0) {
            PersonInfo person = new PersonInfo();
            System.out.println("Enter First Name: ");
            person.setFirstName(scanner.next());

            System.out.println("Enter Last Name : ");
            person.setLastName(scanner.next());
            scanner.nextLine();
            System.out.println("Enter the Address : ");
            person.setAddress(scanner.nextLine());

            System.out.println("Enter the City : ");
            person.setCity(scanner.nextLine());

            System.out.println("Enter the State : ");
            person.setState(scanner.nextLine());

            System.out.println("Enter Email : ");
            person.setEmail(scanner.next());

            System.out.println("Enter  ZipCode : ");
            person.setZipcode(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter Phone Number: ");
            person.setPhoneNumber(scanner.nextLong());

            personList.put(indexValue, person);
            indexValue++;
            System.out.println("Enter 1. To Add More Persons 0.To Exit ");
            userChoice = scanner.nextInt();
        } // end of while loop
    }

    /**
     * uc3- getting name from user and then checking in the personlist. getting
     * user with the username and then comparing with it. if user enter name is
     * true then only the user can edit the data.
     * used iterator through all the values of hashmap and edit that particular records.
     */
    public void editUser() {
        PersonInfo person = new PersonInfo();
        System.out.println("Enter the first name to edit contact.");
        String name = scanner.next();
        Iterator<Integer> iterator = personList.keySet().iterator();

        while (iterator.hasNext()) {
            int key = iterator.next();
            if (personList.get(key).firstName.equals(name)) {
                System.out.println("\nEnter First Name to Edit");
                person.setFirstName(scanner.next());
                scanner.nextLine();
                System.out.println("Enter Last Name to Edit");
                person.setLastName(scanner.next());
                scanner.nextLine();
                System.out.println("Enter Address to Edit");
                person.setAddress(scanner.next());
                scanner.nextLine();
                System.out.println("Enter City to Edit");
                person.setCity(scanner.next());
                System.out.println("Enter State to Edit");
                person.setState(scanner.next());
                scanner.nextLine();
                System.out.println("Enter Zip Code to Edit");
                person.setZipcode(scanner.nextInt());
                System.out.println("Enter Phone Number to Edit");
                person.setPhoneNumber(scanner.nextLong());
                System.out.println("Enter E-mail to Edit");
                person.setEmail(scanner.next());
                personList.put(key, person);
                System.out.println("Contact edited with given first name : " + name);
            }
        }
    }

    /**
     * uc4- getting first name from user and then validating with the personlist
     * name. user will be able to delete the data or record if the inserted
     * input is true.
     *
     */
    public void deleteUser() {

        System.out.println("Enter the First Name");
        String userName = scanner.next();

        Iterator<Integer> iterator = personList.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (personList.get(key).firstName.equals(userName)) {
                personList.remove(key);
                System.out.println("Contact deleted with first name : " + userName);
            }
        } // end of whileloop
    }


    /*
      Displaying user details from the person list.
     */
    private void showContacts() {
        System.out.println(personList);
    }

}
