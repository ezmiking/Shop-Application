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


        // اضافه شدن به سبد خرید
        AnchorPane[] anchorPanes = new AnchorPane[4];
        for (int i = 0; i < 3; i++) {
            URL urlKalaCart = CartPage.class.getResource("/fxml/KalaCartPage.fxml");
            anchorPanes[i] = FXMLLoader.load(urlKalaCart);
            ImageView imageView = (ImageView) anchorPanes[i].getChildren().get(0);
            Label name = (Label) anchorPanes[i].getChildren().get(1);
            Label price = (Label) anchorPanes[i].getChildren().get(2);
           // Label inventoryLbl = (Label) anchorPanes[i].getChildren().get(5);
            //از دیتابیس باید زده بشه

            gridPane.add(anchorPanes[i], 0, i);
        }

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
