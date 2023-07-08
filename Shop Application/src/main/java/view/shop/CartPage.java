package view.shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;

public class CartPage extends Application {
    public static Stage stageCart;
    @Override
    public void start(Stage stage) throws Exception {
        CartPage.stageCart = stage;
        URL urlCart = CartPage.class.getResource("/fxml/cartPage.fxml");

        AnchorPane anchorPane = FXMLLoader.load(urlCart);
        HBox hBox1 = (HBox) anchorPane.getChildren().get(0);
        GridPane gridPane = (GridPane) hBox1.getChildren().get(1);

        URL urlKalaCart = CartPage.class.getResource("/fxml/KalaCartPage.fxml");
        AnchorPane anchorPane1 = FXMLLoader.load(urlKalaCart);
        gridPane.add(anchorPane1, 0, 1);
        // اضافه شدن به سبد خرید
        for (int i = 0; i < 3; i++) {
            ImageView imageView = (ImageView) anchorPane1.getChildren().get(0);
            Label name = (Label) anchorPane1.getChildren().get(1);
            Label price = (Label) anchorPane1.getChildren().get(2);

            //از دیتابیس باید زده بشه

            gridPane.add(anchorPane1, 0, i);
        }

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
