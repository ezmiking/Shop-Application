package view.pay;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PortalPageController {
    public TextField cardNumber;
    public TextField cvv2;
    public TextField year;
    public TextField moth;


    public void payTo(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error in Information");
        if (cardNumber.getText().length() < 16) {
            alert.setContentText("The card number is invalid");
            alert.showAndWait();
        }
        if (cvv2.getText().length() < 3) {
            alert.setContentText("The cvv2 is invalid");
            alert.showAndWait();
        }
        if (Integer.parseInt(year.getText()) < 2023) {
            alert.setContentText("The year is invalid");
            alert.showAndWait();
        }
        if (Integer.parseInt(moth.getText()) < 0 && Integer.parseInt(moth.getText()) > 12) {
            alert.setContentText("The moth is invalid");
            alert.showAndWait();
        }
    }

    public void cancel(MouseEvent mouseEvent) {


    }
}
