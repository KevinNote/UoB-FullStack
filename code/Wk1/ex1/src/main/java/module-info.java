module com.kevinzonda.ex1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kevinzonda.ex1 to javafx.fxml;
    exports com.kevinzonda.ex1;
}