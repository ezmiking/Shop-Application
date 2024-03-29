package view.pay;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.profile.ProfileMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public Image image0;
    public Image image1;
    public Image image2;
    public Image image3;
    public Image image4;
    public Image image5;
    public Image image6;
    public Image image7;
    public Image image8;
    public Image image9;
    public Image image10;
    public Image image11;
    public static int cap = 1181;
    public boolean captchaCodeChecked = true;
    public ArrayList<Image> imageArrayLis = new ArrayList<>();


    public void payTo(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error in Information");
        if (cardNumber.getText().length() < 16) {
            captchaCodeChecked = false;
            alert.setContentText("The card number is invalid");
            System.out.println("The card number is invalid");
            alert.showAndWait();
        }
        else if (cvv2.getText().length() < 3 || cvv2.getText().length() > 4) {
            captchaCodeChecked = false;
            alert.setContentText("The cvv2 is invalid");
            System.out.println("The cvv2 is invalid");
            alert.showAndWait();
        }

        if (year.getText().length() < 4) {
            captchaCodeChecked = false;
            alert.setContentText("The year is invalid");
            System.out.println("The year is invalid");
            alert.showAndWait();
        }
        if (moth.getText().length() == 0) {
            captchaCodeChecked = false;
            alert.setContentText("The moth is invalid");
            System.out.println("The moth is invalid");
            alert.showAndWait();
        }
        //********* captcha test
        captchaCode();
        //*********

        if (password.getText().length() == 0) {
            captchaCodeChecked = false;
            alert.setContentText("The password is invalid");
            System.out.println("The password is invalid");
            alert.showAndWait();
        }
        if (gmail.getText().length() == 0) {
            captchaCodeChecked = false;
            alert.setContentText("The gmail is invalid");
            System.out.println("The gmail is invalid");
            alert.showAndWait();
        }

        if (captchaCodeChecked == true) {

            try {
                new ProfileMenu().start(Portalpage.stagePortal);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            /*
            System.out.println("enter in end page");
            URL urlEndPortal = PortalPageController.class.getResource("/fxml/endPortal.fxml");
            AnchorPane anchorPane = FXMLLoader.load(urlEndPortal);
            Scene sceneEnd = new Scene(anchorPane);
            Portalpage.stagePortal.setTitle("The end of the portal");
            Portalpage.stagePortal.setScene(sceneEnd);
            Portalpage.stagePortal.show();


             */
        }
    }

    public void captchaCode() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (capcha.getText().length() == 0) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("enter captcha");
            alert.showAndWait();
        }
        else if (cap == 1181 && capcha.getText().equals("1181") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1381 && capcha.getText().equals("1381") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1491 && capcha.getText().equals("1491") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1722 && capcha.getText().equals("1722") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 1959 && capcha.getText().equals("1959") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2163 && capcha.getText().equals("2163") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2177 && capcha.getText().equals("2177") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2723 && capcha.getText().equals("2723") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 2785 && capcha.getText().equals("2785") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
        else if (cap == 3541 && capcha.getText().equals("3541") == false) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
            alert.showAndWait();
        }
    }

    public boolean captchaCodeEnter(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (capcha.getText().length() == 0) {
            captchaCodeChecked = false;
            captchaReload();
            alert.setHeaderText("Error in captcha");
            alert.setContentText("enter captcha");
            alert.showAndWait();
            return false;
        }
        if (cap == 1381 && capcha.getText().equals("1381")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 1181 && capcha.getText().equals("1181")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 1491 && capcha.getText().equals("1491")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 1722 && capcha.getText().equals("1722")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 1959 && capcha.getText().equals("1959")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 2163 && capcha.getText().equals("2163")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 2177 && capcha.getText().equals("2177")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 2723 && capcha.getText().equals("2723")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 2785 && capcha.getText().equals("2785")) {
            captchaCodeChecked = true;
            return true;
        }
        if (cap == 3541 && capcha.getText().equals("3541")) {
            captchaCodeChecked = true;
            return true;
        }
        captchaCodeChecked = false;
        captchaReload();
        alert.setHeaderText("Error in captcha");
        alert.setContentText("""
                    Please enter the desired captcha
                    v
                    kh kh kh kh
                    """);
        alert.showAndWait();
        return false;
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
        captchaReload();
    }

    public void captchaReload() {
        Random random = new Random();
        int n = random.nextInt(0, 9);

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