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
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookSystem {

    //Storing person info list inside address book map and then storing it to hashmap. 
    private static Map<String, Set<PersonInfo>> addressBookMap = new HashMap();
    private static Set<PersonInfo> personList = new HashSet<>();

    private String addressBookName;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method from here welcome message is display.
     *
     * @param args
     */
    public static void main(String[] args) {
        // creating object of a addressbook class

        AddressBookSystem addressbook = new AddressBookSystem();
        System.out.println("Welcome to Address Book Program");

        boolean isExit = false;
        while (!isExit) {

            System.out.println("Enter options\n1.Add AddressBook\n2.Edit\n3.Delete\n4.show contacts\n5.search\n6.Exit");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:

                    addressbook.addAddressBook();

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
                    UserInputData.search();

                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        } // end of while loop
    }

    /**
     * uc2- getting input from user and adding it to the address book. for
     * getting personlist with details of person like firstName etc,
     * UserInputData class is created and inside addUserInfo it personList is
     * returned,
     *
     * @see line 85 putting that returned value into personlist.and finally
     * putting it into address book map.
     */
    private void addAddressBook() {

        Set<PersonInfo> personList1 = new HashSet<>();
        System.out.println("Enter the name for your AddressBook : ");
        addressBookName = scanner.next();

        // checking if addressbookmap contain the userinput  addressbook.
        if (addressBookMap.containsKey(addressBookName)) {
            System.out.println(addressBookName + " is already there please choose another name. ");
            addAddressBook();
        } else {

            UserInputData userDetails = new UserInputData();
            personList1 = userDetails.addUserInfo();

            // checking for duplicate values if exist or not.
            if (!(personList1.equals(personList))) {
                addressBookMap.put(addressBookName, personList1);
                System.out.println("person added successfully");

            }
        }
    }

    /**
     * uc3 - getting name from user and then checking in the personlist. getting
     * user with the username and then comparing with it. if user enter name is
     * true then only the user can edit the data.
     *
     */
    public void editUser() {

        System.out.println("Enter the first name to edit contact.");
        String contactName = scanner.next();

        addressBookMap.entrySet().stream().map(entry -> entry.getValue().iterator()).forEachOrdered(itr -> {
            while (itr.hasNext()) {
                if (itr.next().getFirstName().equals(contactName)) {
                    UserInputData userDetails = new UserInputData();
                    personList = userDetails.addUserInfo();
                    System.out.println("Contact edited with given first name : " + contactName);
                    addressBookMap.put(addressBookName, (Set<PersonInfo>) personList);

                } else {
                    System.out.println("Person with this name not found please try with another name.");
                    editUser();
                }
            }
        });

    }

    /**
     * uc4- getting first name from user and then validating with the personlist
     * name. user will be able to delete the data or record if the inserted
     * input is true.
     *
     */
    public void deleteUser() {

        System.out.println("Enter the first name : ");
        String userInput = scanner.next();

        addressBookMap.entrySet().stream().map(entry -> entry.getValue().iterator()).forEachOrdered(itr -> {
            while (itr.hasNext()) {
                if (itr.next().getFirstName().equals(userInput)) {
                    itr.remove();
                    System.out.println("Contact deleted successfully");
                }

            }
        });

    }

    /**
     * Displaying user details from the address book map.
     * it will show all the name of address books and person lists inside that address book.
     */
    private void showContacts() {
        addressBookMap.forEach((String key, Set<PersonInfo> value) -> {
            System.out.println(
                    "AddressBook Name : " + key + "\t\t"
                    + "Person Details : " + value);
        });
    }

}
