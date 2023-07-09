package view.Controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view.shop.KalaPage;
import view.shop.ShopPanel;

public class OneKalaController {

    public static AnchorPane anchorPaneThis;
//    public ShopPanel shopPanel;

    public void enterKala(MouseEvent mouseEvent) throws Exception {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        VBox vBox = (VBox) imageView.getParent();
        anchorPaneThis = (AnchorPane) vBox.getParent();
        new KalaPage().start(ShopPanel.stage);
    }
}
