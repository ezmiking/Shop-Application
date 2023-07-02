package view.pay;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import view.profile.ProfileMenu;

public class CashPageController {

    public static int previousPage = 1; //cashpage --> 2

    public void cancel(MouseEvent mouseEvent) throws Exception {
        new ProfileMenu().start(CashPage.stageChash);
    }

    public void payTo(MouseEvent mouseEvent) throws Exception {
        previousPage = 2;
        new Portalpage().start(CashPage.stageChash);
    }
}
