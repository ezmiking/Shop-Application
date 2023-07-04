package view.login;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SignupPageController extends LoginController {
    public Label lblName;
    public Label lblLastname;
    public TextField txtName;
    public TextField txtLastName;
    public Label lblPassCon;
    public TextField txtFildPassCon;
    public PasswordField passFildPassCon;
    public ImageView imageViewEyeCon;
    public CheckBox read;
    public Label lblHelloName;
    public ImageView successful;
    public Label lblsuccessful;
    public Label welcome;
    private boolean eyeCon = true;
    private static boolean create = true;
    private boolean welcomeB = false;
    private int n = 0;

    public void lastName(KeyEvent keyEvent) {
        if (txtLastName.getText().length() == 0) {
            lblLastname.setVisible(true);
            create = false;
        } else {
            lblLastname.setVisible(false);
            create = true;
        }
    }

    public void name(KeyEvent keyEvent) {
        lblHelloName.setText(txtName.getText());
        if (txtName.getText().length() == 0) {
            lblName.setVisible(true);
            create = false;
        } else {
            lblName.setVisible(false);
            create = true;
        }
    }

    public void txtFildPassCon(KeyEvent keyEvent) {
        n = 0;
        if (txtFildPassCon.getText().length() == 0) {
            lblPassCon.setVisible(true);
            create = false;
        } else {
            lblPassCon.setVisible(false);
            create = true;
        }
    }

    public void passFildPassCon(KeyEvent keyEvent) {
        n = 0;
        if (passFildPassCon.getText().length() == 0) {
            lblPassCon.setVisible(true);
            create = false;
        } else {
            lblPassCon.setVisible(false);
            create = true;
        }
    }

    public void terms(MouseEvent mouseEvent) {
    }

    public void create(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error in Information");
        if (txtName.getText().length() == 0) {
            alert.setContentText("* please enter your Name !!");
            alert.showAndWait();
        }

        if (txtLastName.getText().length() == 0) {
            alert.setContentText("* please enter your Last name !!");
            alert.showAndWait();
        }

        if (txtEmail.getText().length() == 0) {
            alert.setContentText("* please enter your E-mail !!");
            alert.showAndWait();
        }

        if (passFildPass.getText().length() == 0 && txtFildPass.getText().length() == 0) {
            alert.setContentText("* please enter your Password !!");
            alert.showAndWait();
        }

        if (passFildPassCon.getText().length() == 0 && txtFildPassCon.getText().length() == 0) {
            alert.setContentText("* please enter your Confirm Password !!");
            alert.showAndWait();
        }

        if (passFildPass.getText().equals(passFildPassCon.getText()) == false) {
            create = false;
            new Alert(Alert.AlertType.ERROR, """
                    The confirmed password is different from the current password
                    Please enter again
                    """).showAndWait();
            passFildPass.setText("");
            txtFildPass.setText("");
            passFildPassCon.setText("");
            txtFildPassCon.setText("");
            n = -2;
        } else {
            create = true;
        }
        if (read.isSelected()) {
            create = true;
        } else {
            create = false;
            alert.setContentText("* Please read the rules");
            alert.showAndWait();
        }

        if (create == true && n != -2) {
            System.out.println("khkhkh");
            welcomeB = true;
        }

        if (welcomeB == true) {
            successful.setVisible(true);
            lblsuccessful.setVisible(true);
            welcome.setVisible(true);
        }
    }

    public void signin(MouseEvent mouseEvent) throws Exception {
        new LoginMenu().start(SignupPage.stageSignup);
    }

    public void imageViewCon(MouseEvent mouseEvent) {
        setImgeCon();
    }
    
    private void setImgeCon() {
        if (eyeCon == true) { //show pass
            setImageCon1();
            txtFildPassCon.setText(passFildPassCon.getText());
            passFildPassCon.setVisible(false);
            txtFildPassCon.setVisible(true);
            eyeCon = false;
        } else { // hide pass
            setImageCon2();
            passFildPassCon.setVisible(true);
            txtFildPassCon.setVisible(false);
            eyeCon = true;
        }
    }

    private void setImageCon1() {
        imageViewEyeCon.setImage(imageEye2);
    }
    
    private void setImageCon2() {
        imageViewEyeCon.setImage(imageEye1);
    }

    public void initialize() {
        successful.setVisible(false);
        lblsuccessful.setVisible(false);
        welcome.setVisible(false);
    }
}
