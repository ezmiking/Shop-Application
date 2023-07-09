package view.Controller;

import javafx.scene.input.MouseEvent;
import view.pay.CashPage;
import view.shop.CartPage;
import view.shop.KalaPage;
import view.shop.ShopPanel;

public class KalaPageController {

    public void addTo(MouseEvent mouseEvent) throws Exception {

        new CartPage().start(KalaPage.stageKala);
    }

    public void back(MouseEvent mouseEvent) throws Exception {

        new ShopPanel().start(KalaPage.stageKala);
    }
}
