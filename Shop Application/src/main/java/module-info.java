module shopapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.login to javafx.fxml;
    exports view.login;
    opens view.main to javafx.fxml;
    exports view.main;
}