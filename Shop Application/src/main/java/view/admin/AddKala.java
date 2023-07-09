package view.admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class AddKala extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        AddKala.stage = stage;
        URL url = AddKala.class.getResource("/fxml/addKala.fxml");
        VBox vBox = FXMLLoader.load(url);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
