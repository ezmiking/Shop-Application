package view.pay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class CashPage extends Application {
    public static Stage stageChash;
    @Override
    public void start(Stage stage) throws Exception {
        CashPage.stageChash = stage;
        URL urlCash = CashPage.class.getResource("/fxml/cashPage.fxml");
        BorderPane borderPane = FXMLLoader.load(urlCash);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
