package view.pay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Portalpage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL urlPortal = Portalpage.class.getResource("/fxml/portalPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlPortal);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
