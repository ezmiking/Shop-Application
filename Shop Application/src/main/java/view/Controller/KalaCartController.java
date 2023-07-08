package view.Controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class KalaCartController {
    public Label number;
    private String numS;
    private int numI = 0;

    public void toIncrease(MouseEvent mouseEvent) {
        numI++;
        numS = String.valueOf(numI);
        number.setText(numS);
    }

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
