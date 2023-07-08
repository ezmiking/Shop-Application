package view.shop;

import dataBase.DataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class ShopPanel extends Application {
    public static Stage stage;
    DataBase dataBase = new DataBase();
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
            for(int i = 0; i < dataBase.goodArrayList.size(); i++){

            }
        }
        gridPane.add(anchorPane, 0, 0);


        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();
    }
}
