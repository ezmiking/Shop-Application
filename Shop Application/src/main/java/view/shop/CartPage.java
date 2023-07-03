package view.shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class CartPage extends Application {
    public static Stage stageCart;
    @Override
    public void start(Stage stage) throws Exception {
        CartPage.stageCart = stage;
        URL urlCart = CartPage.class.getResource("/fxml/cartPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlCart);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
