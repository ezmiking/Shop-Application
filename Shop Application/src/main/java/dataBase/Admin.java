package dataBase;

public class Admin{

    public Admin(String userName, String password, String firstName, String lastName, String phoneNumber, String email){

        this.setUserName(userName);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
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
}

