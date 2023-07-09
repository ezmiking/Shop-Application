package view.shop;

import dataBase.Admin;
import dataBase.Customer;
import dataBase.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.admin.AddKala;
import view.login.LoginController;
import view.profile.ProfileMenu;

import java.util.ArrayList;

public class ShopPanelController {


    public Button adminSignBtn;
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

    

       

    @FXML
    void adminSignBtnAction(ActionEvent event) throws Exception {
        System.out.println("loginController.sighInAdmin");
        new AddKala().start(ShopPanel.stage);
    }

    public void initialize(){
        if(LoginController.sighInAdmin){
            System.out.println(adminSignBtn);
            adminSignBtn.setVisible(true);
        }
    }
}
