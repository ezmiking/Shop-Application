package view.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.net.URL;

public class PanelShop extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL urlShop = PanelShop.class.getResource("/fxml/panelShop.fxml");
        ScrollPane scrollPane = FXMLLoader.load(urlShop);
        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
