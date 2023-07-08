package view.shop;

import dataBase.Admin;
import dataBase.Customer;
import dataBase.DataBase;
import javafx.event.ActionEvent;
import view.login.LoginController;
import view.profile.ProfileMenu;

import java.util.ArrayList;

public class ShopPanelController {


    LoginController loginController = new LoginController();
    DataBase dataBase = new DataBase();



    public static Admin admin = null;
    public static Customer customer = null;


    public void profile(ActionEvent actionEvent) throws Exception {
        new ProfileMenu().start(ShopPanel.stage);
        System.out.println(admin +" 554");
    }

    public Admin returnAdminShop(){
        System.out.println("returnAdminShop shop "+admin);
        return admin;
    }

    public Customer returnCustomerShop(){
        System.out.println("returnCustomerShop shop "+customer);

        return customer;
    }

    {
        for(int i=0;i<dataBase.goodArrayList.size();i++){

        }
    }


}
