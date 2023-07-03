package view.profile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class ProfileMenu extends Application {
    public static Stage stageProF;
    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenu.stageProF = stage;
        URL urlProf = ProfileMenu.class.getResource("/fxml/profileMenu.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlProf);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
