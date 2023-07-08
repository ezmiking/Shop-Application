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
    private int money = 0;

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

