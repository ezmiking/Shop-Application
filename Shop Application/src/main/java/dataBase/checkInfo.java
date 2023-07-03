package dataBase;

public class checkInfo {


    DataBase dataBase = new DataBase();
    Admin admin;
    Customer customer;
    Good good;



    public boolean checkAdminInfo(String username){

        return (dataBase.checkAdmin(username));
    }
    public boolean checkAdminInfo(String username,String password){
        if(checkAdminInfo(username)){
            admin = dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(admin));
            return admin.getPassword().equals(password);
        }
        return false;
    }
    public boolean checkCustomerInfo(String username){

        return (dataBase.checkCustomer(username));
    }
    public boolean checkCustomerInfo(String username,String password){
        if(checkCustomerInfo(username)){
            customer = dataBase.customerArrayList.get(dataBase.customerArrayList.indexOf(customer));
            return customer.getPassword().equals(password);
        }
        return false;
    }

    public void signUpAdmin(String userName, String password, String firstName, String lastName, String phoneNumber, String email){
        admin = new Admin(userName, password, firstName, lastName, phoneNumber, email);
        dataBase.insertInfoAdmin(userName, password, firstName, lastName, phoneNumber, email);
    }
    public void signUpCustomer(String userName, String password, String firstName, String lastName, String phoneNumber, String email){
        customer = new Customer(userName, password, firstName, lastName, phoneNumber, email);
        dataBase.insertInfoCustomer(userName, password, firstName, lastName, phoneNumber, email);
    }

    public void updateAdminInfo(String userName, String newUserName,String password, String firstName, String lastName, String phoneNumber, String email){
        dataBase.updateInfoAdmin(userName, newUserName, password, firstName, lastName, phoneNumber, email);
    }
    public void updateCustomerInfo(String userName, String newUserName,String password, String firstName, String lastName, String phoneNumber, String email){
        dataBase.updateInfoCustomer(userName, newUserName, password, firstName, lastName, phoneNumber, email);
    }

    public void deleteInfoAdmin(String userName){

        dataBase.deleteInfoAdmin(userName);
    }
    public void deleteInfoCustomer(String userName){


        dataBase.deleteInfoCustomer(userName);
    }









}
