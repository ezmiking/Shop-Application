package dataBase;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
    public ArrayList<Admin> adminArrayList = new ArrayList<>();
    public ArrayList<Customer> customerArrayList = new ArrayList<>();
    public ArrayList<Good> goodArrayList = new ArrayList<>();
    java.sql.Connection databaseAdmin;
    java.sql.Connection databaseCustomer;
    java.sql.Connection databaseGood;


    Statement statementAdmin;
    Statement statementCustomer;
    Statement statementGood;


    /***********************************************************************************/





    /***********************************************************************************/

    {
        //customer
        /***************************************************/
        try {
            databaseCustomer = DriverManager .getConnection(
                    "shopdatabase:customer://localhost:3306:shopdatabase",
                    "root","");

            statementCustomer = databaseCustomer.createStatement();
            ResultSet resultSet = statementCustomer.executeQuery("SELECT * FROM customer");
            while (resultSet.next()){
                Customer customer = new Customer(resultSet.getString("userNameF"),resultSet.getString("passwordF"),
                        resultSet.getString("firstNameF"),resultSet.getString("lastNameF"),
                        resultSet.getString("phoneNumberF"),resultSet.getString("emailF"));


                customerArrayList.add(customer);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean checkCustomer(String userName){
        Customer newCustomer = new Customer(userName);
        return customerArrayList.contains(newCustomer);
    }
    public void insertInfoCustomer(String userName, String password, String firstName, String lastName, String phoneNumber, String email){

        Customer newCustomer = new Customer(userName, password, firstName, lastName, phoneNumber, email);


        try {
            statementCustomer.executeUpdate("INSERT INTO customer " +
                    "(userNameF,passwordF,firstNameF,lastNameF,phoneNumberF,emailF) " +
                    "VALUES (userName,password,firstName,lastName,phoneNumber,email)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        customerArrayList.add(newCustomer);
    }



    public void updateInfoCustomer(String userName,String newUserName, String password, String firstName, String lastName, String phoneNumber, String email){

        Customer customer = new Customer(userName);
        int index = customerArrayList.indexOf(customer);
        Customer changeCustomer = customerArrayList.get(index);
        if(newUserName!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET userNameF = newUserName WHERE userNameF = userName");
                changeCustomer.setUserName(newUserName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(password!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET passwordF = password WHERE userNameF = userName");
                changeCustomer.setPassword(password);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(firstName!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET firstNameF = firstName WHERE userNameF = userName");
                changeCustomer.setFirstName(firstName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(lastName!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET lastNameF = lastName WHERE userNameF = userName");
                changeCustomer.setLastName(lastName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(phoneNumber!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET phoneNumberF = phoneNumber WHERE userNameF = userName");
                changeCustomer.setPhoneNumber(Integer.parseInt(phoneNumber));
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(email!=null){
            try {
                statementCustomer.executeUpdate("UPDATE customer SET emailF = email WHERE userNameF = userName");
                changeCustomer.setEmail(email);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }


    public void deleteInfoCustomer(String userName){
        try {
            statementCustomer.executeUpdate("DELETE FROM customer WHERE userNameF = userName");
            customerArrayList.remove(new Customer(userName));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /***********************************************************************************/

    {
        //admin
        /***************************************************/
        try {
            databaseAdmin = DriverManager .getConnection(
                    "shopdatabase:admin://localhost:3306:shopdatabase",
                    "root","");

            statementAdmin = databaseAdmin.createStatement();
            ResultSet resultSet = statementAdmin.executeQuery("SELECT * FROM admin");
            while (resultSet.next()){
                Admin admin = new Admin(resultSet.getString("userNameF"),resultSet.getString("passwordF"),
                        resultSet.getString("firstNameF"),resultSet.getString("lastNameF"),
                        resultSet.getString("phoneNumberF"),resultSet.getString("emailF"));


                adminArrayList.add(admin);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean checkAdmin(String userName){
        Admin newAdmin = new Admin(userName);
        return adminArrayList.contains(newAdmin);
    }
    public void insertInfoAdmin(String userName, String password, String firstName, String lastName, String phoneNumber, String email){

        Admin newAdmin = new Admin(userName, password, firstName, lastName, phoneNumber, email);


        try {
            statementAdmin.executeUpdate("INSERT INTO admin " +
                    "(userNameF,passwordF,firstNameF,lastNameF,phoneNumberF,emailF) " +
                    "VALUES (userName,password,firstName,lastName,phoneNumber,email)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adminArrayList.add(newAdmin);
    }




    public void updateInfoAdmin( String userName,String newUserName, String password, String firstName, String lastName, String phoneNumber, String email){
        Admin admin = new Admin(userName);
        int index = adminArrayList.indexOf(admin);
        Admin changeAdmin = adminArrayList.get(index);
        if(newUserName!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET userNameF = newUserName WHERE userNameF = userName");
                changeAdmin.setUserName(newUserName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(password!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET passwordF = password WHERE userNameF = userName");
                changeAdmin.setPassword(password);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(firstName!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET firstNameF = firstName WHERE userNameF = userName");
                changeAdmin.setFirstName(firstName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(lastName!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET lastNameF = lastName WHERE userNameF = userName");
                changeAdmin.setLastName(lastName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(phoneNumber!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET phoneNumberF = phoneNumber WHERE userNameF = userName");
                changeAdmin.setPhoneNumber(Integer.parseInt(phoneNumber));
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(email!=null){
            try {
                statementAdmin.executeUpdate("UPDATE admin SET emailF = email WHERE userNameF = userName");
                changeAdmin.setEmail(email);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }

    public void deleteInfoAdmin(String userName){
        try {
            statementAdmin.executeUpdate("DELETE FROM admin WHERE userNameF = userName");
            adminArrayList.remove(new Admin(userName));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /***********************************************************************************/

    {
        //GOOD
        /***************************************************/
        try {
            databaseGood = DriverManager .getConnection(
                    "shopdatabase:good://localhost:3306:shopdatabase",
                    "root","");

            statementGood = databaseGood.createStatement();
            ResultSet resultSet = statementGood.executeQuery("SELECT * FROM good");
            while (resultSet.next()){
                Good good = new Good(resultSet.getString("nameGoodF"),resultSet.getString("companyNameF"),
                        resultSet.getInt("inventoryGoodF"),resultSet.getInt("discountGoodF"),
                        resultSet.getInt("pointGoodF"),resultSet.getString("imageAddressGood"));
                good.setCodeGood(resultSet.getInt("codeGoodF"));


                goodArrayList.add(good.getCodeGood(),good);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    /*************************************************************************************/

}

