package view.shop;

import javafx.scene.input.MouseEvent;
import view.pay.PaymentPage;

public class CartPageController {
    public void payTo(MouseEvent mouseEvent) throws Exception {
        new PaymentPage().start(CartPage.stageCart);
    }
}
