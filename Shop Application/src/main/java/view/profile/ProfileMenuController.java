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
        /*
        if(shopPanelController.admin!=null){
            name.setText(shopPanelController.admin.getFirstName());
            lastName.setText(shopPanelController.admin.getLastName());
            gmail.setText(shopPanelController.admin.getEmail());
            passwordField.setText(shopPanelController.admin.getPassword());
            textFieldPassword.setText(shopPanelController.admin.getPassword());
        }else if(shopPanelController.customer!=null){
        name.setText(shopPanelController.customer.getFirstName());
        lastName.setText(shopPanelController.customer.getLastName());
        gmail.setText(shopPanelController.customer.getEmail());
        passwordField.setText(shopPanelController.customer.getPassword());
        textFieldPassword.setText(shopPanelController.customer.getPassword());
        }
*/
    }

    public void saveInformation(MouseEvent mouseEvent) {

    }

    public void inventoryIncrease(MouseEvent mouseEvent) throws Exception {
        new CashPage().start(ProfileMenu.stageProF);
    }
}
