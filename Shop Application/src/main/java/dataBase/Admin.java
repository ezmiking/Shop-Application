package dataBase;

import java.io.Serializable;

public class Admin implements Serializable {

    public Admin(String userName, String password, String firstName, String lastName, String email){

        this.setUserName(userName);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setMoney(0);
    }

    public Admin(String userName){

        this.setUserName(userName);
    }

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int money;

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
        Admin other =(Admin) obj;
        return this.getUserName().equals(other.getUserName());
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

