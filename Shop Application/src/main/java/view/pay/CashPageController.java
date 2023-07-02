package view.pay;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.profile.ProfileMenu;

public class CashPageController {

    public static int previousPage = 1; //cashpage --> 2
    public TextField cash;
    public RadioButton mellat;
    public RadioButton melli;

    public void cancel(MouseEvent mouseEvent) throws Exception {
        new ProfileMenu().start(CashPage.stageChash);
    }

    public void payTo(MouseEvent mouseEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setHeaderText("""
            Error in Information
            """);
        if (cash.getText().length() == 0) {

            alert.setContentText("""
            The desired amount has not been entered
            Not all fields are filled
            """);
            alert.showAndWait();
        }
        else if (mellat.isSelected() == false && melli.isSelected() == false) {
            alert.setContentText("Please select your bank");
            alert.showAndWait();
        }
        else {
        previousPage = 2;
        new Portalpage().start(CashPage.stageChash);
        }
    }

    public void mellat(MouseEvent mouseEvent) {
        if (mellat.isSelected()) {
            melli.setSelected(false);
        }
    }

    public void melli(MouseEvent mouseEvent) {
        if (melli.isSelected()) {
            mellat.setSelected(false);
        }
    }
}
