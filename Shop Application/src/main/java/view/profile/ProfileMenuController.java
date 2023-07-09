package view.profile;

import dataBase.Admin;
import dataBase.CheckInfo;
import dataBase.Customer;
import dataBase.DataBase;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.pay.CashPage;
import view.pay.CashPageController;
import view.shop.ShopPanelController;

import java.sql.SQLException;

public class ProfileMenuController {
    DataBase dataBase = new DataBase();
    CheckInfo checkInfo = new CheckInfo();
    public TextField name;
    public TextField lastName;
    public TextField gmail;
    public TextField textFieldPassword;
    public PasswordField passwordField;
    public RadioButton showPassword;

    public Label cash;

    public void showPassword(MouseEvent mouseEvent) {
        if (showPassword.isSelected()) {
            textFieldPassword.setText(passwordField.getText());
            passwordField.setVisible(false);
            textFieldPassword.setVisible(true);
        }
        else {
            passwordField.setVisible(true);
            textFieldPassword.setVisible(false);
        }
    }

    public void initialize() {


        if(ShopPanelController.admin!=null){
            Admin admin = dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(ShopPanelController.admin));
            name.setText(admin.getFirstName());
            lastName.setText(admin.getLastName());
            gmail.setText(admin.getEmail());
            passwordField.setText(admin.getPassword());
            textFieldPassword.setText(admin.getPassword());
            System.out.println("profile admin info");
            cash.setText(String.valueOf(admin.getMoney()));
            int cashValue = Integer.parseInt(cash.getText());
            cash.setText(String.valueOf(cashValue+ CashPageController.cashValue));
            try {
                dataBase.updateInfoAdmin(admin.getUserName(),null,null,null,null,null,cashValue+ CashPageController.cashValue);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if(ShopPanelController.customer!=null){
            Customer customer = dataBase.customerArrayList.get(dataBase.customerArrayList.indexOf(ShopPanelController.customer));
            name.setText(customer.getFirstName());
            lastName.setText(customer.getLastName());
            gmail.setText(customer.getEmail());
            passwordField.setText(customer.getPassword());
            textFieldPassword.setText(customer.getPassword());
            System.out.println("profile customer info");
            cash.setText(String.valueOf(customer.getMoney()));
            int cashValue = Integer.parseInt(cash.getText());
            cash.setText(String.valueOf(cashValue+ CashPageController.cashValue));
            try {
                dataBase.updateInfoCustomer(customer.getUserName(),null,null,null,null,CashPageController.cashValue,null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("empty");

        }

    }

    public void saveInformation(MouseEvent mouseEvent) throws SQLException {
        if(ShopPanelController.admin!=null){
            checkInfo.updateAdminInfo(ShopPanelController.admin.getUserName(), gmail.getText(),
                    passwordField.getText(),name.getText(),lastName.getText(),gmail.getText(),0);
        }else if (ShopPanelController.customer!=null){
            checkInfo.updateCustomerInfo(ShopPanelController.customer.getUserName(), gmail.getText(),
                    passwordField.getText(),name.getText(),lastName.getText(),ShopPanelController.customer.getMoney(),gmail.getText());
        }
    }

    public void inventoryIncrease(MouseEvent mouseEvent) throws Exception {
        new CashPage().start(ProfileMenu.stageProF);
    }
}
