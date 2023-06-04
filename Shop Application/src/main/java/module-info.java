module com.example.shopapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.login to javafx.fxml;
    exports view.login;
}