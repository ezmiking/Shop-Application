package view.Controller;

import dataBase.DataBase;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class KalaCartController {
    DataBase dataBase = new DataBase();

    public Label number;
    public int inventory;
    private String numS;
    public int numI = 0;

    public void toIncrease(MouseEvent mouseEvent) {
        numI++;
        numS = String.valueOf(numI);
        number.setText(numS);

    }

    /*
    {
       // inventory = Integer.parseInt(inventoryLbl.getText());
    }

     */
    public void toLessen(MouseEvent mouseEvent) {
        if (numI > 0) {
            numI--;
            numS = String.valueOf(numI);
            number.setText(numS);
        } else {
            System.out.println("حذف از سبد خرید");
        }
    }
}
