package view.login;

import dataBase.Admin;
import dataBase.CheckInfo;
import dataBase.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.shop.ShopPanel;

public class LoginController {
    DataBase dataBase = new DataBase();
    CheckInfo checkInfo = new CheckInfo();
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    public void singIn(MouseEvent mouseEvent) throws Exception {
        String userNameString = usernameField.getText();
        String passwordString = passwordField.getText();
        //check admin is available
        if (checkInfo.checkAdminInfo(userNameString)){
            //check admin password
            if(checkInfo.checkAdminInfo(userNameString, passwordString)){
                //password is correct
                new ShopPanel().start(LoginMenu.stage);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Admin SING IN ERROR");
                alert.setContentText("your password is wrong");
                alert.showAndWait();
               // System.out.println(dataBase.adminArrayList.get(dataBase.adminArrayList.indexOf(new Admin(userNameString))).getPassword());
            }
        }else if(checkInfo.checkCustomerInfo(userNameString)){
            //check customer password
            if(checkInfo.checkCustomerInfo(userNameString, passwordString)){
                //password is correct
                new ShopPanel().start(LoginMenu.stage);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Customer SING IN ERROR");
                alert.setContentText("your password is wrong");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("not allow");
            alert.setContentText("you did not join to our shop");
            alert.showAndWait();
        }


    }

    public void singUp(MouseEvent mouseEvent) {

    }


    public void reset(MouseEvent mouseEvent) {
        usernameField.setText("");
        passwordField.setText("");
    }
}
