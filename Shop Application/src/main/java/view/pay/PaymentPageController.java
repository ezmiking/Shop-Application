package view.pay;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PaymentPageController {
    public TextField country;
    public Label starcountry;
    public TextField province;
    public TextField city;
    public TextField exact;
    public TextField phone;
    public TextField postcode;
    public Label countryE;
    public Label provinceE;
    public Label cityE;
    public Label exaxtE;
    public Label phoneE;
    public Label postcodeE;
    public Button toPay;
    private boolean sw = false;
    private int check = 0;

//    public void initialize() {
//        check();
//    }
//    public void check() {
//    }


    public void toPay(MouseEvent mouseEvent) throws Exception {
        if (country.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the country");
            alert.showAndWait();
        }
        else if (province.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the province");
            alert.showAndWait();
        }
        else if (city.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the city");
            alert.showAndWait();
        }
        else if (exact.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the exact");
            alert.showAndWait();
        }
        else if (phone.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the phone number");
            alert.showAndWait();
        }
        else if (postcode.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Warining in Information");
            alert.setContentText("You did not enter the name of the postcode");
            alert.showAndWait();
        }
        else {
            CashPageController.previousPage = 1;
            new Portalpage().start(PaymentPage.stagePay);
        }
    }

    public void countryKy(KeyEvent keyEvent) {
        if (country.getText().length() == 0) {
            countryE.setVisible(true);
            sw = false;
            check--;
        } else {
            countryE.setVisible(false);
            sw = true;
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }

    public void provinceKy(KeyEvent keyEvent) {
        if (province.getText().length() == 0) {
            provinceE.setVisible(true);
            check--;
        } else {
            provinceE.setVisible(false);
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }

    public void cityKy(KeyEvent keyEvent) {
        if (city.getText().length() == 0) {
            cityE.setVisible(true);
            check--;
        } else {
            cityE.setVisible(false);
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }


    public void exactKy(KeyEvent keyEvent) {
        if (exact.getText().length() == 0) {
            exaxtE.setVisible(true);
            check--;
        } else {
            exaxtE.setVisible(false);
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }

    public void phoneKy(KeyEvent keyEvent) {
        if (phone.getText().length() == 0) {
            phoneE.setVisible(true);
            check--;
        } else {
            phoneE.setVisible(false);
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }

    public void postKy(KeyEvent keyEvent) {
        if (postcode.getText().length() == 0) {
            postcodeE.setVisible(true);
            check--;
        } else {
            postcodeE.setVisible(false);
            check++;
        }
        if (postcodeE.isVisible() == false && phoneE.isVisible() == false && exaxtE.isVisible() == false && cityE.isVisible() == false && provinceE.isVisible() == false && countryE.isVisible() == false) {
            toPay.setDisable(false);
        } else {
            toPay.setDisable(true);
        }
    }
}
