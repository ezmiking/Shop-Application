package view.shop;

import dataBase.Admin;
import dataBase.Customer;
import dataBase.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.login.LoginController;
import view.profile.ProfileMenu;

public class ShopPanelController {
//    LoginController loginController = new LoginController();
//    DataBase dataBase = new DataBase();
//    public Admin admin = null;
//    public Customer customer = null;

    public void profile(ActionEvent actionEvent) throws Exception {
        new ProfileMenu().start(ShopPanel.stage);
    }
    /*
    {
        if(loginController.returnAdmin()!=null){
            admin = loginController.returnAdmin();
            admin = dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(admin));
            System.out.println("Admin enter");
        }else if(loginController.returnCustomer()!=null){
            customer = loginController.returnCustomer();
            customer = dataBase.customerArrayList.get(dataBase.customerArrayList.indexOf(customer));
            System.out.println("Customer enter");

        }
    }
    */

}
