package view.login;

import dataBase.CheckInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SignupController extends LoginController {

    CheckInfo checkInfo = new CheckInfo();
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
    public CheckBox adminCheckBox;
    public CheckBox customerCheckBox;
    private boolean adminSign = false;
    private boolean customerSign = false;
    private boolean emailNotAvailable = true;
    private boolean eyeCon = true;
    private static boolean create = true;
    private boolean welcomeB = false;
    private int n = 0;
    @FXML
    void adminBoxAction(ActionEvent event) {
        if(adminCheckBox.isSelected()){
            adminSign = true;
            customerSign=false;
            customerCheckBox.setSelected(false);
        }
        if(!adminCheckBox.isSelected()){
            adminSign = false;
            customerSign=true;
            customerCheckBox.setSelected(true);
        }
    }
    @FXML
    void customerBoxAction(ActionEvent event) {
        if(customerCheckBox.isSelected()){
            adminSign = false;
            customerSign=true;
            adminCheckBox.setSelected(false);
        }
        if(!customerCheckBox.isSelected()){
            adminSign = true;
            customerSign=false;
            adminCheckBox.setSelected(true);
        }
    }
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
        }
         else {
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
         if(checkInfo.checkCustomerInfo(txtEmail.getText())){
            alert.setContentText("* this Email is available");
            alert.showAndWait();
            emailNotAvailable = false;
        }else{
             emailNotAvailable=true;
         }
        if(checkInfo.checkAdminInfo(txtEmail.getText())){
            alert.setContentText("* this Email is available");
            alert.showAndWait();
            emailNotAvailable = false;
        }else{
            emailNotAvailable=true;
        }
         if (txtEmail.getText().length() == 0) {
            alert.setContentText("* please enter your E-mail !!");
            alert.showAndWait();
             emailNotAvailable = false;
         }else{
             emailNotAvailable=true;
         }



        if (passFieldPass.getText().length() == 0 && txtFieldPass.getText().length() == 0) {
            alert.setContentText("* please enter your Password !!");
            alert.showAndWait();
        }

        if (passFildPassCon.getText().length() == 0 && txtFildPassCon.getText().length() == 0) {
            alert.setContentText("* please enter your Confirm Password !!");
            alert.showAndWait();
        }

        else if (!passFieldPass.getText().equals(passFildPassCon.getText())) {
            create = false;
            new Alert(Alert.AlertType.ERROR, """
                    The confirmed password is different from the current password
                    Please enter again
                    """).showAndWait();
            passFieldPass.setText("");
            txtFieldPass.setText("");
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

        if (create && n != -2) {
//            System.out.println("khkhkh");
            welcomeB = true;
        }

        if (welcomeB) {
            if(adminSign && emailNotAvailable){
                checkInfo.signUpAdmin(txtEmail.getText(),passFieldPass.getText(),
                        txtName.getText(),txtLastName.getText(),txtEmail.getText());
            }
            if(customerSign && emailNotAvailable){
                checkInfo.signUpCustomer(txtEmail.getText(),passFieldPass.getText(),
                        txtName.getText(),txtLastName.getText(),txtEmail.getText());
            }
            successful.setVisible(true);
            lblsuccessful.setVisible(true);
            welcome.setVisible(true);
        }
    }

    public void signIn(MouseEvent mouseEvent) throws Exception {
        new LoginMenu().start(SignupPage.stageSignup);
    }

    public void imageViewCon(MouseEvent mouseEvent) {
        setImageCon();
    }
    
    private void setImageCon() {
        if (eyeCon) { //show pass
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
