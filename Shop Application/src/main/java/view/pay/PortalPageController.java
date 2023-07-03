package view.pay;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class PortalPageController {
    public TextField capcha;
    public ImageView imageCapcha;
    public AnchorPane anccc;
    public Button reload;
    public TextField password;
    public TextField gmail;
    private CashPageController cashPageController;
    public TextField cardNumber;
    public TextField cvv2;
    public TextField year;
    public TextField moth;
    private Image image0;
    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;
    private Image image5;
    private Image image6;
    private Image image7;
    private Image image8;
    private Image image9;
    private Image image10;
    private Image image11;
    private static int cap = 1181;
    public ArrayList<Image> imageArrayLis = new ArrayList<>();


    public void payTo(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error in Information");
        if (cardNumber.getText().length() < 16) {
            alert.setContentText("The card number is invalid");
            System.out.println("The card number is invalid");
            alert.showAndWait();
        }
        if (cvv2.getText().length() < 3 || cvv2.getText().length() > 4) {
            alert.setContentText("The cvv2 is invalid");
            System.out.println("The cvv2 is invalid");
            alert.showAndWait();
        }

        if (year.getText().length() < 4) {
            alert.setContentText("The year is invalid");
            System.out.println("The year is invalid");
            alert.showAndWait();
        }
        if (moth.getText().length() == 0) {
            alert.setContentText("The moth is invalid");
            System.out.println("The moth is invalid");
            alert.showAndWait();
        }


        System.out.println("captch:" + capcha.getText());
        System.out.println("cap:" + cap);
        if (capcha.getText().length() == 0) {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("enter captcha");
            alert.showAndWait();
        }
        else if (cap == 1181 && capcha.getText() != "1181") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1381 && capcha.getText() != "1381") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1491 && capcha.getText() != "1491") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1722 && capcha.getText() != "1722") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1959 && capcha.getText() != "1959") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2163 && capcha.getText() != "2163") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2177 && capcha.getText() != "2177") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            System.out.println(2177);
            alert.showAndWait();
        }
        else if (cap == 2723 && capcha.getText() != "2723") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2785 && capcha.getText() != "2785") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 3541 && capcha.getText() != "3541") {
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        } else System.out.println("Payment was successful");

        if (password.getText().length() == 0) {
            alert.setContentText("The password is invalid");
            System.out.println("The password is invalid");
            alert.showAndWait();
        }
        if (gmail.getText().length() == 0) {
            alert.setContentText("The gmail is invalid");
            System.out.println("The gmail is invalid");
            alert.showAndWait();
        }
    }

    public void cancel(MouseEvent mouseEvent) throws Exception {
        if (CashPageController.previousPage == 1) {
            new PaymentPage().start(Portalpage.stagePortal);
        }
        else if (CashPageController.previousPage == 2) {
            new CashPage().start(Portalpage.stagePortal);
        }
    }


    public void reload(MouseEvent mouseEvent) {
        Random random = new Random();
        int n = random.nextInt(0, 9);
        System.out.println(n);
        image0 = new Image(PortalPageController.class.getResourceAsStream("/captcha/1181.png"));
        image1 = new Image(PortalPageController.class.getResourceAsStream("/captcha/1381.png"));
        image2 = new Image(PortalPageController.class.getResourceAsStream("/captcha/1491.png"));
        image3 = new Image(PortalPageController.class.getResourceAsStream("/captcha/1722.png"));
        image4 = new Image(PortalPageController.class.getResourceAsStream("/captcha/1959.png"));
        image5 = new Image(PortalPageController.class.getResourceAsStream("/captcha/2163.png"));
        image6 = new Image(PortalPageController.class.getResourceAsStream("/captcha/2177.png"));
        image7 = new Image(PortalPageController.class.getResourceAsStream("/captcha/2723.png"));
        image8 = new Image(PortalPageController.class.getResourceAsStream("/captcha/2785.png"));
        image9 = new Image(PortalPageController.class.getResourceAsStream("/captcha/3541.png"));
        imageArrayLis.add(image0);
        imageArrayLis.add(image1);
        imageArrayLis.add(image2);
        imageArrayLis.add(image3);
        imageArrayLis.add(image4);
        imageArrayLis.add(image5);
        imageArrayLis.add(image6);
        imageArrayLis.add(image7);
        imageArrayLis.add(image8);
        imageArrayLis.add(image9);
        switch (n) {
            case 0:
                cap = 1181;
                break;
            case 1:
                cap = 1381;
                break;
            case 2:
                cap = 1491;
                break;
            case 3:
                cap = 1722;
                break;
            case 4:
                cap = 1959;
                break;
            case 5:
                cap = 2163;
                break;
            case 6:
                cap = 2177;
                break;
            case 7:
                cap = 2723;
                break;
            case 8:
                cap = 2785;
                break;
            case 9:
                cap = 3541;
                break;
        }


        imageCapcha.setImage(imageArrayLis.get(n));
    }

    private void initialize() throws FileNotFoundException {

    }

    public void textField(KeyEvent keyEvent) {
    }
}