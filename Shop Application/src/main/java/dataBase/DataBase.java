package dataBase;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
    private final int port =3306;
    public ArrayList<Admin> adminArrayList = new ArrayList<>();
    public ArrayList<Customer> customerArrayList = new ArrayList<>();
    public ArrayList<Good> goodArrayList = new ArrayList<>();


    java.sql.Connection database;
    Statement statement;


    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
    }
    ResultSet resultSetAdmin;
    ResultSet resultSetCustomer;
    ResultSet resultSetGood;




    /***********************************************************************************/


    {
        try {
            //database = DriverManager.getConnection("jdbc:mysql:176.65.241.166/sheedtab_amir", "sheedtab_amir","amirreza_Daneshmand1382");
            database = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdatabase", "root","");
            //database = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/shopdatabase", "root","");
            //database = DriverManager.getConnection("jdbc:mysql://127.0.0.1 :3306/shopdatabase", "root","");
            statement = database.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    /***********************************************************************************/
    //customer

    {
        //customer
        /***************************************************/
        try {

            resultSetCustomer = statement.executeQuery("SELECT * FROM customer");

            while (resultSetCustomer.next()) {
                Customer customer = new Customer(resultSetCustomer.getString("userNameF"), resultSetCustomer.getString("passwordF"),
                        resultSetCustomer.getString("firstNameF"), resultSetCustomer.getString("lastNameF"),
                        resultSetCustomer.getString("phoneNumberF"), resultSetCustomer.getString("emailF"));


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
            statement.executeUpdate("INSERT INTO customer " +
                    "(userNameF,passwordF,firstNameF,lastNameF,phoneNumberF,emailF) " +
                    "VALUES (userName,password,firstName,lastName,phoneNumber,email)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        customerArrayList.add(newCustomer);
    }
    public void insertInfoCustomer(Customer customer){
        String userName = customer.getUserName();
        String password = customer.getPassword();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        insertInfoCustomer(userName,password,firstName,lastName,phoneNumber,email);
    }



    public void updateInfoCustomer(String userName,String newUserName, String password, String firstName, String lastName, String phoneNumber, String email){

        Customer customer = new Customer(userName);
        int index = customerArrayList.indexOf(customer);
        Customer changeCustomer = customerArrayList.get(index);
        if(newUserName!=null){
            try {
                statement.executeUpdate("UPDATE customer SET userNameF = newUserName WHERE userNameF = userName");
                changeCustomer.setUserName(newUserName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(password!=null){
            try {
                statement.executeUpdate("UPDATE customer SET passwordF = password WHERE userNameF = userName");
                changeCustomer.setPassword(password);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(firstName!=null){
            try {
                statement.executeUpdate("UPDATE customer SET firstNameF = firstName WHERE userNameF = userName");
                changeCustomer.setFirstName(firstName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(lastName!=null){
            try {
                statement.executeUpdate("UPDATE customer SET lastNameF = lastName WHERE userNameF = userName");
                changeCustomer.setLastName(lastName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(phoneNumber!=null){
            try {
                statement.executeUpdate("UPDATE customer SET phoneNumberF = phoneNumber WHERE userNameF = userName");
                changeCustomer.setPhoneNumber(phoneNumber);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(email!=null){
            try {
                statement.executeUpdate("UPDATE customer SET emailF = email WHERE userNameF = userName");
                changeCustomer.setEmail(email);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }
    public void updateInfoCustomer(Customer customer,Customer newCustomer){
        String userName = customer.getUserName();
        String newUserName = newCustomer.getUserName();
        String password = newCustomer.getPassword();
        String firstName = newCustomer.getFirstName();
        String lastName = newCustomer.getLastName();
        String phoneNumber = newCustomer.getPhoneNumber();
        String email = newCustomer.getEmail();
        updateInfoCustomer(userName,newUserName,password,firstName,lastName,phoneNumber,email);
    }


    public void deleteInfoCustomer(String userName){
        try {
            statement.executeUpdate("DELETE FROM customer WHERE userNameF = userName");
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



            resultSetAdmin = statement.executeQuery("SELECT * FROM admin");
            while (resultSetAdmin.next()){
                Admin admin = new Admin(resultSetAdmin.getString("userNameF"),resultSetAdmin.getString("passwordF"),
                        resultSetAdmin.getString("firstNameF"),resultSetAdmin.getString("lastNameF"),
                        resultSetAdmin.getString("phoneNumberF"),resultSetAdmin.getString("emailF"));


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
            statement.executeUpdate("INSERT INTO admin " +
                    "(userNameF,passwordF,firstNameF,lastNameF,phoneNumberF,emailF) " +
                    "VALUES (userName,password,firstName,lastName,phoneNumber,email)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adminArrayList.add(newAdmin);
    }
    public void insertInfoAdmin(Admin admin){
        String userName = admin.getUserName();
        String password = admin.getPassword();
        String firstName = admin.getFirstName();
        String lastName = admin.getLastName();
        String phoneNumber = admin.getPhoneNumber();
        String email = admin.getEmail();
        insertInfoAdmin(userName,password,firstName,lastName,phoneNumber,email);
    }




    public void updateInfoAdmin( String userName,String newUserName, String password, String firstName, String lastName, String phoneNumber, String email){
        Admin admin = new Admin(userName);
        int index = adminArrayList.indexOf(admin);
        Admin changeAdmin = adminArrayList.get(index);
        if(newUserName!=null){
            try {
                statement.executeUpdate("UPDATE admin SET userNameF = newUserName WHERE userNameF = userName");
                changeAdmin.setUserName(newUserName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(password!=null){
            try {
                statement.executeUpdate("UPDATE admin SET passwordF = password WHERE userNameF = userName");
                changeAdmin.setPassword(password);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(firstName!=null){
            try {
                statement.executeUpdate("UPDATE admin SET firstNameF = firstName WHERE userNameF = userName");
                changeAdmin.setFirstName(firstName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(lastName!=null){
            try {
                statement.executeUpdate("UPDATE admin SET lastNameF = lastName WHERE userNameF = userName");
                changeAdmin.setLastName(lastName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(phoneNumber!=null){
            try {
                statement.executeUpdate("UPDATE admin SET phoneNumberF = phoneNumber WHERE userNameF = userName");
                changeAdmin.setPhoneNumber(phoneNumber);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(email!=null){
            try {
                statement.executeUpdate("UPDATE admin SET emailF = email WHERE userNameF = userName");
                changeAdmin.setEmail(email);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }
    public void updateInfoAdmin(Admin admin,Admin newAdmin){
        String userName = admin.getUserName();
        String newUserName = newAdmin.getUserName();
        String password = newAdmin.getPassword();
        String firstName = newAdmin.getFirstName();
        String lastName = newAdmin.getLastName();
        String phoneNumber = newAdmin.getPhoneNumber();
        String email = newAdmin.getEmail();
        updateInfoAdmin(userName,newUserName,password,firstName,lastName,phoneNumber,email);
    }

    public void deleteInfoAdmin(String userName){
        try {
            statement.executeUpdate("DELETE FROM admin WHERE userNameF = userName");
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
            resultSetGood = statement.executeQuery("SELECT * FROM good");
            while (resultSetGood.next()){
                Good good = new Good(resultSetGood.getString("nameGoodF"),resultSetGood.getString("companyNameF"),
                        resultSetGood.getInt("inventoryGoodF"),resultSetGood.getInt("discountGoodF"),
                        resultSetGood.getInt("pointGoodF"),resultSetGood.getString("imageAddressGood"));
                good.setCodeGood(resultSetGood.getInt("codeGoodF"));


                goodArrayList.add(good.getCodeGood(),good);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    /*************************************************************************************/

}

