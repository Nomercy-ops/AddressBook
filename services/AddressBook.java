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
	
	/**
     * uc2- getting input from user and adding it to the addressbook. for
     * storing the input arrayList has been used. all the person details is
     * stored in a person list arraylist.
     */
    private void addPerson() {

        PersonInfo person = new PersonInfo();
        System.out.println("Enter First Name: ");
        person.setFirstName(scanner.next());

        System.out.println("Enter Last Name : ");
        person.setLastName(scanner.next());

        System.out.println("Enter the Address : ");
        person.setAddress(scanner.next());

        System.out.println("Enter the City : ");
        person.setCity(scanner.next());

        System.out.println("Enter the State : ");
        person.setState(scanner.next());

        System.out.println("Enter Email : ");
        person.setEmail(scanner.next());

        System.out.println("Enter  ZipCode : ");
        person.setZipcode(scanner.nextInt());

        System.out.println("Enter Phone Number: ");
        person.setPhoneNumber(scanner.nextLong());
        personList.add(person);

    }
	
	/**
     * uc3- getting  name from user and then checking in the personlist.
     * getting user with the username and then comparing with it. if user enter
     * name is true then only the user can edit the data.
     */
    
    public void editUser() {
        System.out.println("Enter the Person name");
        String userName = scanner.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equals(userName)) {
                PersonInfo temp = personList.get(i);
                do {
                    System.out.println("1: edit Phone Number : ");
                    System.out.println("2: edit Address : ");
                    System.out.println("3: edit City : ");
                    System.out.println("4: edit ZipCode : ");
                    System.out.println("5: edit State : ");
                    System.out.println("6: edit Email : ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the new Number");
                            temp.setPhoneNumber(scanner.nextLong());
                            break;
                        case 2:
                            System.out.println("Enter the new Address");
                            temp.setAddress(scanner.next());
                            break;
                        case 3:
                            System.out.println("Enter the new city");
                            temp.setCity(scanner.next());
                            break;
                        case 4:
                            System.out.println("Enter the new ZipCode");
                            temp.setZipcode(scanner.nextInt());
                            break;
                        case 5:
                            System.out.println("Enter the new State");
                            temp.setState(scanner.next());
                            break;
                        case 6:
                            System.out.println("Enter the new Email");
                            temp.setEmail(scanner.next());
                            break;
                        default:
                            System.out.println("Enter the correct Input");

                    }
                    System.out.println("If you want to edit more thing than enter true");
                } while (scanner.nextBoolean());
            } // end of  if statement
        } // end of for loop

    }
	
}