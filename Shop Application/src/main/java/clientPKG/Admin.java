package clientPKG;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Admin implements Comparable, Serializable {

    public Admin(String userName, String password, String firstName, String lastName, String phoneNumber, String email){

        this.userName=userName;
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(Integer.parseInt(phoneNumber));
        setEmail(email);
    }

    public Admin(String userName){

        this.userName=userName;
    }

    private final String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Admin other =(Admin) o;
        if(this.userName.equals(other.getUserName())){
            return 1;
        }
        return -1;
    }
    @Override
    public boolean equals(Object obj){
        Admin other =(Admin) obj;
        return this.userName.equals(other.getUserName());
    }
}

