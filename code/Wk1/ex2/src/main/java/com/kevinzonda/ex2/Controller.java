package com.kevinzonda.ex2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField txtName;

    @FXML
    protected void onSubmitClicked() {
        System.out.println(txtName.getText());
    }
}