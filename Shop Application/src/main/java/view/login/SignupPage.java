package view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class SignupPage extends Application {
    public static Stage stageSignup;
    @Override
    public void start(Stage stage) throws Exception {
        SignupPage.stageSignup = stage;
        URL urlSignup = SignupPage.class.getResource("/fxml/signupPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlSignup);
        Scene scene = new Scene(anchorPane);
        stage.setTitle("Login Menu");
        stage.setScene(scene);
        stage.show();
    }
}
