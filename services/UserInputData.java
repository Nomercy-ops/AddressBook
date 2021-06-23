package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.PersonInfo;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class UserInputData {

    // these collection are for storing key as city name and values as persons of same city vice versa.
    private static Map<String, ArrayList<String>> addressBookSearchList = new HashMap<>();

    /**
     * This method is used for adding person into a person list and then further
     * added to address book by returning from here.
     *
     *
     * @return personlist.
     */
    public Set<PersonInfo> addUserInfo() {
        String cityName;
        String personName;

        Scanner scanner = new Scanner(System.in);
        Set<PersonInfo> personList = new HashSet<>();
        String prompt;

        do {

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
            person.setZipcode(scanner.next());
            scanner.nextLine();
            System.out.println("Enter Phone Number: ");
            person.setPhoneNumber(scanner.next());
            personList.add(person);

            // getting person name and person city and passedfor mapping.
            cityName = person.getCity();
            personName = person.getFirstName();
            mapPersonWithCity(cityName, personName);
            System.out.println("Would you like to continue?(yes/no)");
            prompt = scanner.next();
        } while (prompt.equalsIgnoreCase( //this loop ends if user does not wants to add more contacts.

                "yes"));
        return personList; // this lists is retorned to the addAddressbook method.
    }

    /**
     * UC8 and Uc9 - mapping persons with same city. This method is used for storing city
     * and persons separately.
     *
     * @param city
     * @param personName
     */
    public static void mapPersonWithCity(String city, String personName) {

        if (addressBookSearchList.containsKey(city)) {
            ArrayList<String> person;
            person = addressBookSearchList.get(city);
            person.add(personName);
            addressBookSearchList.put(city, person);
        } else {
            ArrayList<String> person = new ArrayList<>();
            person.add(personName);
            addressBookSearchList.put(city, person);
            person = null;
        }
		
	/**
     * UC - 10 Ability to get number of contact persons count by City.
     * This is the search method for getting the persons list with the same
     * city.
     */
    public static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name : ");
        String userInput = scanner.next();
        if (addressBookSearchList.containsKey(userInput)) {
            System.out.println("The persons list are :" + addressBookSearchList.get(userInput) + " ");
            System.out.println("he count of person with this city are :" + addressBookSearchList.get(userInput).size());
        } else {
            System.out.println("city does not exists!");
        }
        long cityCount = addressBookSearchList.entrySet().stream()
                .filter(p -> p.getKey().equals(userInput))
                .count();

    }

}	

    }

   