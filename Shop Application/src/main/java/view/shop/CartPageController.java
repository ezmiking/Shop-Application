package view.shop;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import view.pay.PaymentPage;

public class CartPageController {
    public void payTo(MouseEvent mouseEvent) throws Exception {
        new PaymentPage().start(CartPage.stageCart);
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        new KalaPage().start(CartPage.stageCart);
    }


}
