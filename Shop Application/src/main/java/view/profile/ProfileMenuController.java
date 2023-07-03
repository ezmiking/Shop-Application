package view.profile;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.pay.CashPage;

public class ProfileMenuController {
    public TextField name;
    public TextField lastName;
    public TextField phoneNumber;
    public TextField gmail;
    public TextField textFieldPassword;
    public PasswordField passwordField;
    public RadioButton showPassword;
    public TextField data;
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
        name.setText("Amir");
        lastName.setText("khadem");
        phoneNumber.setText("09150952624");
        data.setText("12/25/2003");
        gmail.setText("alipi82.alipir82@gmail.com");
        passwordField.setText("ezmi2325");
        textFieldPassword.setText("ezmi2325");
    }

    public void saveInformation(MouseEvent mouseEvent) {

    }

    public void inventoryIncrease(MouseEvent mouseEvent) throws Exception {
        new CashPage().start(ProfileMenu.stageProF);
    }
}
