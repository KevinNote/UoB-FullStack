module com.kevinzonda.ex2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kevinzonda.ex2 to javafx.fxml;
    exports com.kevinzonda.ex2;
}