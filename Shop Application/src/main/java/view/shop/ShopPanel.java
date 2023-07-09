package view.shop;

import dataBase.DataBase;
import dataBase.Good;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class ShopPanel extends Application {
    public static Stage stage;
    public DataBase dataBase = new DataBase();
    public /*static */AnchorPane[] anchorPanes = new AnchorPane[100];
    public ArrayList<AnchorPane> anchorPanesArrayList = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        ShopPanel.stage = stage;
        URL urlShop = ShopPanel.class.getResource("/fxml/shopPanel.fxml");
        ScrollPane scrollPane = FXMLLoader.load(urlShop);
        BorderPane borderPane = (BorderPane) scrollPane.getContent();
        GridPane gridPane = (GridPane) borderPane.getCenter();



        {
            int i = 0, j = 0;
            for (int k = 0; k < dataBase.goodArrayList.size(); k++) {
                URL urlkala = ShopPanel.class.getResource("/fxml/oneKala.fxml");
                anchorPanes[k] = FXMLLoader.load(urlkala);
                Good good = dataBase.goodArrayList.get(k);
                VBox vBox = (VBox) anchorPanes[k].getChildren().get(0);
                HBox hBox1 = (HBox) vBox.getChildren().get(3);
                HBox hBox2 = (HBox) vBox.getChildren().get(4);
                ImageView imageView = (ImageView) vBox.getChildren().get(0);
                Label name = (Label) vBox.getChildren().get(1);
                Label score = (Label) vBox.getChildren().get(2);
                Label brand = (Label) hBox1.getChildren().get(1);
                Label price = (Label) hBox2.getChildren().get(1);
//                ImageView pastive = (ImageView) hBox2.getChildren().get(2);
                name.setText(good.getNameGood());
                score.setText(String.valueOf(good.getPointGood()));
                brand.setText(good.getCompanyName());
                price.setText(String.valueOf(good.getPriceGood()));

                imageView.setImage(new Image(ShopPanel.class.getResourceAsStream(good.getImageAddressGood())));




                gridPane.add(anchorPanes[k], j, i);
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
