package view.shop;

import dataBase.Admin;
import dataBase.Customer;
import dataBase.DataBase;
import view.login.LoginController;

public class ShopPanelController {
    LoginController loginController = new LoginController();
    DataBase dataBase = new DataBase();
    Admin admin = null;
    Customer customer = null;
    {
        if(loginController.returnAdmin()!=null){
            admin = loginController.returnAdmin();
            admin = dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(admin));
        }else{
            customer = loginController.returnCustomer();
            customer = dataBase.customerArrayList.get(dataBase.customerArrayList.indexOf(customer));
        }
    }
}
