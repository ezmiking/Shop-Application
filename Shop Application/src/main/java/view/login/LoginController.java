package view.login;

import dataBase.CheckInfo;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import view.pay.PortalPageController;

public class LoginController extends PortalPageController {
    //CheckInfo checkInfo = new CheckInfo();
    public Label lblEmail;
    public TextField txtEmail;
    public Label lblPass;
    public TextField txtFieldPass;
    public PasswordField passFieldPass;
    public ImageView imageViewEye;
    protected Image imageEye1;
    protected Image imageEye2;
    protected boolean eye = true;

    public void signIn(MouseEvent mouseEvent) {

        if (txtEmail.getText().length() == 0) {
            checked = false;
            new Alert(Alert.AlertType.ERROR, """
                    please enter your Email
                    """).showAndWait();
        }
        eye = false;
        setImage();
        if (passFieldPass.getText().length() == 0 && txtFieldPass.getText().length() == 0) {
            checked = false;
            new Alert(Alert.AlertType.ERROR, """
                    please enter your Password
                    """).showAndWait();
        }
        captchaCode();
        if (checked == true) {
            System.out.println("haaayaa");
        }
    }

    public void signUp(MouseEvent mouseEvent) throws Exception {
        new SignupPage().start(LoginMenu.stage);
    }

    public void imageView(MouseEvent mouseEvent) {
        setImage();
    }

    protected void setImage() {
        if (eye == true) { //show pass
            setImage1();
            txtFieldPass.setText(passFieldPass.getText());
            passFieldPass.setVisible(false);
            txtFieldPass.setVisible(true);
            eye = false;
        } else { // hide pass
            setImage2();
            passFieldPass.setVisible(true);
            txtFieldPass.setVisible(false);
            eye = true;
        }
    }

    protected void setImage1() {
        imageEye2 = new Image(LoginController.class.getResourceAsStream("/image/icon/eye2.png"));
//        if (imageViewEye.getImage().equals(image1) == true) {
//            imageViewEye.setImage(image2);
//        }
//        else {
//            imageViewEye.setImage(image1);
//        }
        imageViewEye.setImage(imageEye2);
    }

    protected void setImage2() {
        imageEye1 = new Image(LoginController.class.getResourceAsStream("/image/icon/eye1.png"));
        imageViewEye.setImage(imageEye1);
    }

    public void email(KeyEvent keyEvent) {
        if (txtEmail.getText().length() == 0) {
            lblEmail.setVisible(true);
        } else {
            lblEmail.setVisible(false);
        }
    }

    public void txtFildPass(KeyEvent keyEvent) {
        if (txtFieldPass.getText().length() == 0) {
            lblPass.setVisible(true);
        } else {
            lblPass.setVisible(false);
        }
    }

    public void passFildPass(KeyEvent keyEvent) {
        if (passFieldPass.getText().length() == 0) {
            lblPass.setVisible(true);
        } else {
            lblPass.setVisible(false);
        }
    }

    @Override
    public void captchaReload() {
        super.captchaReload();
    }

    @Override
    public void captchaCode() {
        super.captchaCode();
    }

    public void reloadCaptcha(MouseEvent mouseEvent) { // تابع عکس ریلود
        captchaReload();
    }
}
