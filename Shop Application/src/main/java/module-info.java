module shopapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires java.sql;


    opens view.login to javafx.fxml;
    exports view.login;
    opens view.shop to javafx.fxml;
    exports view.shop;
    opens view.pay to javafx.fxml;
    exports view.pay;
    opens view.profile to javafx.fxml;
    exports view.profile;
    exports view.Controller;
    opens view.Controller to javafx.fxml;
}