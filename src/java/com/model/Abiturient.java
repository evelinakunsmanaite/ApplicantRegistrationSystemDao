package com.model;

public class Abiturient {
    
    private int id;
    private String  password, login, firstName,middleName ,lastName, telephone, address,noten;

    public Abiturient(int id, String login, String password,String firstName,String middleName, String lastName, String telephone, String address, String noten) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.noten = noten;
    }
    
        public Abiturient(String login, String password,String firstName,String middleName, String lastName, String telephone, String address, String noten) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.noten = noten;
    }
    
        public Abiturient(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
