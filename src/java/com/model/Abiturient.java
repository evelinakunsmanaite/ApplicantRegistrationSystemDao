package com.model;

public class Abiturient {
    
    private int id;
    private String  firstName,middleName ,lastName, patronimic, telephone, address,noten;

    public Abiturient(int id, String firstName, String lastName, String patronimic, String telephone, String address, String noten) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.patronimic = patronimic;
        this.telephone = telephone;
        this.address = address;
        this.noten = noten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoten() {
        return noten;
    }

    public void setNoten(String noten) {
        this.noten = noten;
    }

    public Abiturient() {
    }

}
