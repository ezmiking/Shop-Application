package dataBase;



import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private final int port =3306;
    public ArrayList<Admin> adminArrayList = new ArrayList<>();
    public ArrayList<Customer> customerArrayList = new ArrayList<>();
    public ArrayList<Good> goodArrayList = new ArrayList<>();


    java.sql.Connection database;
    Statement statement;


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
                        resultSetCustomer.getString("emailF"));
                customer.setMoney(resultSetCustomer.getInt("moneyF"));

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
    /*
    public void insertInfoCustomer(String userName, String password, String firstName, String lastName, String email){

        Customer newCustomer = new Customer(userName, password, firstName, lastName, email);


        int money = newCustomer.getMoney();
        System.out.println(userName);
        //PreparedStatement customerInsert;
        String SQL = "INSERT INTO customer (userNameF, passwordF, firstNameF, lastNameF, moneyF,emailF) VALUES (" + userName + ", " + password + ", " + firstName + "," + lastName + ", " + money + ", " + email + ");";
       ///String SQL = "UPDATE customer SET userNameF = " + newUserName + "WHERE userNameF = " + userName ";";
        //String SQL = "UPDATE customer SET userNameF = newUserName WHERE userNameF = userName";

        try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
            customerInsert.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        customerArrayList.add(newCustomer);
    }

     */
    /*
    public void insertInfoCustomer(String userName, String password, String firstName, String lastName, String email) throws SQLException {
        Customer newCustomer = new Customer(userName, password, firstName, lastName, email);
        int money = newCustomer.getMoney();
        statement.executeUpdate("INSERT INTO 'customer'(userNameF, passwordF, firstNameF, lastNameF, moneyF,emailF) VALUE ('"+userName+"','"+password+"','"+firstName+"','"+lastName+"','"+money+"','"+email+"') ");
    }

     */
    public void insertInfoCustomer(String userName, String password, String firstName, String lastName, String email) throws SQLException {
        Customer newCustomer = new Customer(userName, password, firstName, lastName, email);
        int money = newCustomer.getMoney();
        PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO customer (userNameF, passwordF, firstNameF, lastNameF, moneyF,emailF) VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,firstName);
        preparedStatement.setString(4,lastName);
        preparedStatement.setInt(5,money);
        preparedStatement.setString(6,email);
        preparedStatement.executeUpdate();
    }

        public void insertInfoCustomer(Customer customer) throws SQLException {
        String userName = customer.getUserName();
        String password = customer.getPassword();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String email = customer.getEmail();
        int money = customer.getMoney();
        insertInfoCustomer(userName,password,firstName,lastName,email);
    }



    public void updateInfoCustomer(String userName,String newUserName, String password, String firstName, String lastName,int money, String email) throws SQLException {

        Customer customer = new Customer(userName);
        int index = customerArrayList.indexOf(customer);
        Customer changeCustomer = customerArrayList.get(index);
        /*
        *
        * String SQL = "UPDATE products SET score = " + newScore + ", vote_count = " + voteCount + " WHERE product_id = " + ProductPage.PRODUCT_ID + ";";
        try (Connection connection = establishConnection("shop"); PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        * */
        if(newUserName!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET userNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,newUserName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeCustomer.setUserName(newUserName);
            customerArrayList.set(index, changeCustomer);
            /*
            String SQL = "UPDATE customer SET userNameF = " + newUserName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setUserName(newUserName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
           /* try {
                statement.executeUpdate("UPDATE customer SET userNameF = newUserName WHERE userNameF = userName");
                changeCustomer.setUserName(newUserName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(password!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET passwordF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeCustomer.setPassword(password);
            customerArrayList.set(index, changeCustomer);
            /*
            String SQL = "UPDATE customer SET passwordF = " + password +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setPassword(password);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET passwordF = password WHERE userNameF = userName");
                changeCustomer.setPassword(password);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(firstName!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET firstNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeCustomer.setFirstName(firstName);
            customerArrayList.set(index, changeCustomer);
            /*
            String SQL = "UPDATE customer SET firstNameF = " + firstName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setFirstName(firstName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET firstNameF = firstName WHERE userNameF = userName");
                changeCustomer.setFirstName(firstName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(lastName!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET lastNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,lastName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeCustomer.setLastName(lastName);
            customerArrayList.set(index, changeCustomer);
            /*
            String SQL = "UPDATE customer SET lastNameF = " + lastName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setLastName(lastName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET lastNameF = lastName WHERE userNameF = userName");
                changeCustomer.setLastName(lastName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }

        if(email!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET emailF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeCustomer.setEmail(email);
            customerArrayList.set(index, changeCustomer);
            /*
            String SQL = "UPDATE customer SET emailF = " + email +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setEmail(email);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET emailF = email WHERE userNameF = userName");
                changeCustomer.setEmail(email);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(money!=0){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE customer SET moneyF = ? WHERE userNameF = ?");
            preparedStatement.setInt(1,money);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            /*
            String SQL = "UPDATE customer SET moneyF = " + email +" WHERE money = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeCustomer.setMoney(money);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET moneyF = money WHERE userNameF = userName");
                changeCustomer.setMoney(money);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }




    }
    public void updateInfoCustomer(Customer customer,Customer newCustomer) throws SQLException {
        String userName = customer.getUserName();
        String newUserName = newCustomer.getUserName();
        String password = newCustomer.getPassword();
        String firstName = newCustomer.getFirstName();
        String lastName = newCustomer.getLastName();
        String email = newCustomer.getEmail();
        int money = newCustomer.getMoney();
        updateInfoCustomer(userName,newUserName,password,firstName,lastName,money,email);
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
                        resultSetAdmin.getString("emailF"));


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
    /*
    public void insertInfoAdmin(String userName, String password, String firstName, String lastName, String email){

        Admin newAdmin = new Admin(userName, password, firstName, lastName, email);

        String SQL = "INSERT INTO admin (userNameF,passwordF,firstNameF,lastNameF,emailF) VALUES (" + userName + ", " + password + ", " + firstName + ", " + lastName + ", " + email + ");";

        try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
            customerInsert.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*try {
            statement.executeUpdate("INSERT INTO admin " +
                    "(userNameF,passwordF,firstNameF,lastNameF,emailF) " +
                    "VALUES (userName,password,firstName,lastName,email)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adminArrayList.add(newAdmin);
    }
    */

    public void insertInfoAdmin(String userName, String password, String firstName, String lastName, String email) throws SQLException {

        Admin newAdmin = new Admin(userName, password, firstName, lastName, email);
        PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO admin (userNameF,passwordF,firstNameF,lastNameF,emailF) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,firstName);
        preparedStatement.setString(4,lastName);
        preparedStatement.setString(5,email);
        preparedStatement.executeUpdate();
    }
        public void insertInfoAdmin(Admin admin) throws SQLException {
        String userName = admin.getUserName();
        String password = admin.getPassword();
        String firstName = admin.getFirstName();
        String lastName = admin.getLastName();
        String phoneNumber = admin.getPhoneNumber();
        String email = admin.getEmail();
        insertInfoAdmin(userName,password,firstName,lastName,email);
    }




    public void updateInfoAdmin( String userName,String newUserName, String password, String firstName, String lastName, String email) throws SQLException {
        Admin admin = new Admin(userName);
        int index = adminArrayList.indexOf(admin);
        Admin changeAdmin = adminArrayList.get(index);
        //PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO admin (userNameF,passwordF,firstNameF,lastNameF,emailF) VALUES (?,?,?,?,?)");
//        PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET userNameF = ? WHERE userNameF = ?");
//        preparedStatement.setString(1,newUserName);
//        preparedStatement.setString(2,userName);
//        preparedStatement.executeUpdate();
        if(newUserName!=null){

            PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET userNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,newUserName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeAdmin.setUserName(newUserName);
            adminArrayList.set(index, changeAdmin);
            /*
            String SQL = "UPDATE admin SET userNameF = " + newUserName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeAdmin.setUserName(newUserName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/

           /* try {
                statement.executeUpdate("UPDATE customer SET userNameF = newUserName WHERE userNameF = userName");
                changeCustomer.setUserName(newUserName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(password!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET passwordF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeAdmin.setPassword(password);
            adminArrayList.set(index, changeAdmin);
            /*
            String SQL = "UPDATE admin SET passwordF = " + password +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeAdmin.setPassword(password);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET passwordF = password WHERE userNameF = userName");
                changeCustomer.setPassword(password);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(firstName!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET firstNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeAdmin.setFirstName(firstName);
            adminArrayList.set(index, changeAdmin);
            /*
            String SQL = "UPDATE admin SET firstNameF = " + firstName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeAdmin.setFirstName(firstName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET firstNameF = firstName WHERE userNameF = userName");
                changeCustomer.setFirstName(firstName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
        if(lastName!=null){
            PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET lastNameF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,lastName);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeAdmin.setLastName(lastName);
            adminArrayList.set(index, changeAdmin);
            /*
            String SQL = "UPDATE admin SET lastNameF = " + lastName +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeAdmin.setLastName(lastName);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET lastNameF = lastName WHERE userNameF = userName");
                changeCustomer.setLastName(lastName);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }

        if(email!=null){

            PreparedStatement preparedStatement = database.prepareStatement("UPDATE admin SET emailF = ? WHERE userNameF = ?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
            changeAdmin.setEmail(email);
            adminArrayList.set(index, changeAdmin);
            /*
            String SQL = "UPDATE admin SET emailF = " + email +" WHERE userNameF = " + userName + ";";
            try (PreparedStatement customerInsert = database.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
                customerInsert.execute();
                changeAdmin.setEmail(email);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

             */
            /*
            try {
                statement.executeUpdate("UPDATE customer SET emailF = email WHERE userNameF = userName");
                changeCustomer.setEmail(email);
                customerArrayList.set(index, changeCustomer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }


        /*
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

        if(email!=null){
            try {
                statement.executeUpdate("UPDATE admin SET emailF = email WHERE userNameF = userName");
                changeAdmin.setEmail(email);
                adminArrayList.set(index, changeAdmin);
            } catch (SQLException e) {
                throw new RuntimeException(e);

        }*/



    }
    public void updateInfoAdmin(Admin admin, Admin newAdmin) throws SQLException {
        String userName = admin.getUserName();
        String newUserName = newAdmin.getUserName();
        String password = newAdmin.getPassword();
        String firstName = newAdmin.getFirstName();
        String lastName = newAdmin.getLastName();

        String email = newAdmin.getEmail();
        updateInfoAdmin(userName,newUserName,password,firstName,lastName,email);
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
                Good good = new Good(resultSetGood.getString("nameGoodF") ,resultSetGood.getInt("priceGoodF"),resultSetGood.getString("companyNameF"),
                        resultSetGood.getInt("inventoryGoodF"),resultSetGood.getInt("discountGoodF"),
                        resultSetGood.getInt("pointGoodF"),resultSetGood.getString("imageAddressGoodF"));
                good.setCodeGood(resultSetGood.getInt("codeGoodF"));


                goodArrayList.add(good);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void insertInfoGood(String nameGood,int priceGood, String companyName, int inventoryGood, String imageAddressGood) throws SQLException {

        Good good = new Good(nameGood, priceGood, companyName, inventoryGood, 0,0,imageAddressGood);
        PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO good (nameGoodF,priceGoodF,companyNameF,inventoryGoodF,discountGoodF,pointGoodF,imageAddressGoodF) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setString(1,nameGood);
        preparedStatement.setString(2, String.valueOf(priceGood));
        preparedStatement.setString(3,companyName);
        preparedStatement.setString(4, String.valueOf(inventoryGood));
        preparedStatement.setString(5, String.valueOf(0));
        preparedStatement.setString(6, String.valueOf(0));
        preparedStatement.setString(7,imageAddressGood);
        preparedStatement.executeUpdate();
    }
    public void updateInfoGood(String nameGood ,int invertory) throws SQLException {
        Good good = new Good(nameGood);
        int index = goodArrayList.indexOf(good);
        good = goodArrayList.get(index);
        good.setInventoryGood(invertory);
        goodArrayList.set(index, good);
        PreparedStatement preparedStatement = database.prepareStatement("UPDATE good SET invertoryF = ? WHERE nameGoodF = ?");
        preparedStatement.setInt(1,invertory);
        preparedStatement.setString(2,nameGood);
        preparedStatement.executeUpdate();

    }
    /*************************************************************************************/

}

