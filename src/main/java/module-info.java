module com.example.textredstepik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textredstepik to javafx.fxml;
    exports com.example.textredstepik;
}