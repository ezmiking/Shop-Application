package view.shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

import static view.Controller.OneKalaController.anchorPaneThis;

//import static view.shop.ShopPanel.anchorPanes;

public class KalaPage extends Application {
    public static Stage stageKala;
    @Override
    public void start(Stage stage) throws Exception {
        KalaPage.stageKala = stage;
        URL urlKala = KalaPage.class.getResource("/fxml/kalaPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(urlKala);

        ImageView imageViewKala = (ImageView) anchorPane.getChildren().get(0);
        Label nameKala = (Label) anchorPane.getChildren().get(3);
        Label priceKala = (Label) anchorPane.getChildren().get(4);
        Label scoreKala = (Label) anchorPane.getChildren().get(6);

        VBox vBox = (VBox) anchorPaneThis.getChildren().get(0);
        HBox hBox2 = (HBox) vBox.getChildren().get(4);
        ImageView imageView = (ImageView) vBox.getChildren().get(0);
        Label name = (Label) vBox.getChildren().get(1);
        Label score = (Label) vBox.getChildren().get(2);
        Label price = (Label) hBox2.getChildren().get(1);

        nameKala.setText(name.getText());
        scoreKala.setText(score.getText());
        priceKala.setText(price.getText());
        imageViewKala.setImage(imageView.getImage());


        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
