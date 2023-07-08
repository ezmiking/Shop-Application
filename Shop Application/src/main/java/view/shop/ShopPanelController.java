package view.shop;

import dataBase.Admin;
import dataBase.Customer;
import dataBase.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.login.LoginController;
import view.profile.ProfileMenu;

public class ShopPanelController {

    LoginController loginController = new LoginController();
    DataBase dataBase = new DataBase();
    private Admin admin = null;
    private Customer customer = null;
    {
        if(loginController.sighInAdmin){
            admin = loginController.returnAdmin();
            admin = dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(admin));
            System.out.println("admin move");
        } else if (loginController.sighInCustomer) {
            customer = loginController.returnCustomer();
            customer = dataBase.customerArrayList.get(dataBase.customerArrayList.indexOf(customer));
            System.out.println("customer move");
        }
    }

    public void profile(ActionEvent actionEvent) throws Exception {
        new ProfileMenu().start(ShopPanel.stage);
    }

    public Admin returnAdminShop(){
        return admin;
    }

    public Customer returnCustomerShop(){
        return customer;
    }

}
