package view.Controller;

import dataBase.DataBase;
import dataBase.Good;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.admin.AddKala;
import view.shop.ShopPanel;

import java.sql.SQLException;

public class AddKalaController {
    public TextField nameG;
    public TextField companyG;
    public TextField priceG;
    public TextField invertoryG;
    public TextField imageG;
    DataBase dataBase = new DataBase();

    public void backAddKalaAction(MouseEvent mouseEvent) throws Exception {
        new ShopPanel().start(AddKala.stage);
    }

    public void addAddKalaAction(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(nameG.getText().equals(null)){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("please check your info again ");
            alert.showAndWait();

        }
        else if(companyG.getText().equals(null)){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("please check your info again ");
            alert.showAndWait();

        }
        else if(priceG.getText().equals(null)){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("please check your info again ");
            alert.showAndWait();

        }
        else if(invertoryG.getText().equals(null)){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("please check your info again ");
            alert.showAndWait();

        }
        else if(imageG.getText().equals(null)){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("please check your info again ");
            alert.showAndWait();

        }
        else if(dataBase.goodArrayList.contains(new Good(nameG.getText()))){
            alert.setTitle("ERROR");
            alert.setHeaderText("add kala IN ERROR");


            alert.setContentText("kala is available");
            alert.showAndWait();

        }
        else{
            int price = Integer.parseInt(priceG.getText());
            int invertory = Integer.parseInt(invertoryG.getText());
            try {
                dataBase.insertInfoGood(nameG.getText(),price,companyG.getText(),invertory,imageG.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
