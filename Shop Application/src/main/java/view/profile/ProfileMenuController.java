package view.profile;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.pay.CashPage;
import view.shop.ShopPanelController;

public class ProfileMenuController {
    ShopPanelController shopPanelController = new ShopPanelController();
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

        if(shopPanelController.returnAdminShop()!=null){
            name.setText(shopPanelController.returnAdminShop().getFirstName());
            lastName.setText(shopPanelController.returnAdminShop().getLastName());
            gmail.setText(shopPanelController.returnAdminShop().getEmail());
            passwordField.setText(shopPanelController.returnAdminShop().getPassword());
            textFieldPassword.setText(shopPanelController.returnAdminShop().getPassword());
            System.out.println("profile admin info");
        }else if(shopPanelController.returnCustomerShop()!=null){
            name.setText(shopPanelController.returnCustomerShop().getFirstName());
            lastName.setText(shopPanelController.returnCustomerShop().getLastName());
            gmail.setText(shopPanelController.returnCustomerShop().getEmail());
            passwordField.setText(shopPanelController.returnCustomerShop().getPassword());
            textFieldPassword.setText(shopPanelController.returnCustomerShop().getPassword());
            System.out.println("profile customer info");
        }

    }

    public void saveInformation(MouseEvent mouseEvent) {

    }

    public void inventoryIncrease(MouseEvent mouseEvent) throws Exception {
        new CashPage().start(ProfileMenu.stageProF);
    }
}
