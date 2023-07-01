module shopapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.login to javafx.fxml;
    exports view.login;
    opens view.main to javafx.fxml;
    exports view.main;
    opens view.pay to javafx.fxml;
    exports view.pay;
    opens view.profile to javafx.fxml;
    exports view.profile;
}