package com.bridgelabz.AddressBook.Model;

/**
 * this is PersonInfo class model for address book here getter and setter is
 * used to get and set the value of a address book user uc1- Ability to create a
 * contacts in AddressBook with first and last name. from this model we can
 * create an address book by using these methods.
 */
public class PersonInfo {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private int zipcode;
    private long phoneNumber;

    /*The getter method returns the value of the attribute.
    The setter method takes a parameter and assigns it to the attribute.*/
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //This method returns the string itself.
    @Override
    public String toString() {
        return "PersonInfo{" + " firstName= " + firstName + ", lastName= " + lastName + ", address= " + address + ", city= " + city + ", state= " + state + ", email= " + email + ", phoneNumber= " + phoneNumber + '}';
    }

}
