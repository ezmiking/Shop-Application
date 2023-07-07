package dataBase;

import java.io.Serializable;

public class Customer implements Serializable {
    public Customer(String userName, String password, String firstName, String lastName, String email){

       setUserName(userName);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public Customer(String userName){

       setUserName(userName);
    }
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber = null;

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj){
        Customer other =(Customer) obj;
        return this.getUserName().equals(other.getUserName());
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

