package view.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.net.URL;

public class ShopPanel extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL urlShop = ShopPanel.class.getResource("/fxml/shopPanel.fxml");
        ScrollPane scrollPane = FXMLLoader.load(urlShop);
        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();
    }
}
