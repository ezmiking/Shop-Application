package view.pay;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class PaymentPage extends Application {
    public static Stage stagePay;
    @Override
    public void start(Stage stage) throws Exception {
        PaymentPage.stagePay = stage;
        URL urlPayment = PaymentPage.class.getResource("/fxml/paymentPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlPayment);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

}
