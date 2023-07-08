package view.shop;

import dataBase.DataBase;
import dataBase.Good;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;

public class ShopPanel extends Application {
    public static Stage stage;
    public DataBase dataBase = new DataBase();
    public Good good = new Good( "nameGood", "companyName", 85, 0, 3, "imageAddressGood");
    @Override
    public void start(Stage stage) throws Exception {
        ShopPanel.stage = stage;
        URL urlShop = ShopPanel.class.getResource("/fxml/shopPanel.fxml");
        ScrollPane scrollPane = FXMLLoader.load(urlShop);
        BorderPane borderPane = (BorderPane) scrollPane.getContent();
        GridPane gridPane = (GridPane) borderPane.getCenter();

        URL url = ShopPanel.class.getResource("/fxml/oneKala.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);


        {
            int i = 0, j = 0;
            for (int k = 0; k < dataBase.goodArrayList.size(); k++) {
                VBox vBox = (VBox) anchorPane.getChildren().get(0);
                HBox hBox1 = (HBox) vBox.getChildren().get(3);
                HBox hBox2 = (HBox) vBox.getChildren().get(4);
                ImageView imageView = (ImageView) vBox.getChildren().get(0);
                Label name = (Label) vBox.getChildren().get(1);
                Label score = (Label) vBox.getChildren().get(2);
                Label brand = (Label) hBox1.getChildren().get(1);
                Label price = (Label) hBox2.getChildren().get(1);
//                ImageView pastive = (ImageView) hBox2.getChildren().get(2);







                gridPane.add(anchorPane, j, i);
                if(j == 2) {
                    i++;
                    j = 0;
                }
                else {
                    j++;
                }
            }
        }


        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();
    }
}
