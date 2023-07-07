//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dataBase;

public class CheckInfo {
    DataBase dataBase = new DataBase();
    Admin admin;
    Customer customer;
    Good good;

    public CheckInfo() {
    }

    public boolean checkAdminInfo(String username) {
        return this.dataBase.checkAdmin(username);
    }

    public boolean checkAdminInfo(String username, String password) {
        if (this.checkAdminInfo(username)) {
            this.admin = (Admin)this.dataBase.adminArrayList.get(this.dataBase.adminArrayList.indexOf(new Admin(username)));
            return this.admin.getPassword().equals(password);
        } else {
            return false;
        }
    }

    public boolean checkCustomerInfo(String username) {
        return this.dataBase.checkCustomer(username);
    }

    public boolean checkCustomerInfo(String username, String password) {
        if (this.checkCustomerInfo(username)) {
            this.customer = (Customer)this.dataBase.customerArrayList.get(this.dataBase.customerArrayList.indexOf(new Customer(username)));
            return this.customer.getPassword().equals(password);
        } else {
            return false;
        }
    }

    public void signUpAdmin(String userName, String password, String firstName, String lastName, String email) {
        this.admin = new Admin(userName, password, firstName, lastName, email);
        this.dataBase.insertInfoAdmin(userName, password, firstName, lastName, email);
    }

    public void signUpCustomer(String userName, String password, String firstName, String lastName, String email) {
        this.customer = new Customer(userName, password, firstName, lastName, email);
        this.dataBase.insertInfoCustomer(userName, password, firstName, lastName, email);
    }

    public void updateAdminInfo(String userName, String newUserName, String password, String firstName, String lastName, String email) {
        this.dataBase.updateInfoAdmin(userName, newUserName, password, firstName, lastName, email);
    }

    public void updateCustomerInfo(String userName, String newUserName, String password, String firstName, String lastName, String email) {
        this.dataBase.updateInfoCustomer(userName, newUserName, password, firstName, lastName, email);
    }

    public void deleteInfoAdmin(String userName) {
        this.dataBase.deleteInfoAdmin(userName);
    }

    public void deleteInfoCustomer(String userName) {
        this.dataBase.deleteInfoCustomer(userName);
    }
}
