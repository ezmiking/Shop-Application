package view.login;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.main.PanelShop;

public class LoginController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    public void singIn(MouseEvent mouseEvent) throws Exception {
        if (password.getText().length() < 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("SING IN ERROR");
            alert.setContentText("your password is weak");
            alert.showAndWait();
        }
        else {
            new PanelShop().start(LoginMenu.stage);
        }
    }

    public void singUp(MouseEvent mouseEvent) {

    }


    public void reset(MouseEvent mouseEvent) {
        username.setText("");
        password.setText("");
    }
}
