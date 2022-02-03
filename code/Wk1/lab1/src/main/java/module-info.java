module com.kevinzonda.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kevinzonda.lab1 to javafx.fxml;
    exports com.kevinzonda.lab1;
}