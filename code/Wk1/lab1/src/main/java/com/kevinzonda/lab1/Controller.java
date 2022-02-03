package com.kevinzonda.lab1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextField txtName;

    @FXML
    private ToggleGroup tggCrust;

    @FXML
    private RadioButton rdoThin;

    @FXML
    private RadioButton rdoThick;

    @FXML
    private ChoiceBox<String> ccbToppings;

    @FXML
    private Label lblBranch;

    @FXML
    private ListView<String> lstBranch;

    @FXML
    private Label lblMsg;

    ObservableList<String> branches =
            FXCollections.observableArrayList(
                    "Selly Oak",
                    "Bournville",
                    "Solihil"
            );

    ObservableList<String> tops =
            FXCollections.observableArrayList(
                    "Cheese",
                    "Pepper",
                    "Tofu"
            );

    @FXML
    private void initialize() {
        rdoThick.setSelected(true);
        lstBranch.setItems(branches);
        ccbToppings.setItems(tops);
        lstBranch.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        lblBranch.setText(newValue);
                    }
                }
        );
    }

    @FXML
    protected void onSubmitClicked() {
        float price = 0;
        if (rdoThin.isSelected()) {
            price += 1.00f;
        } else {
            price += 0.50f;
        }
        lblMsg.setText(
                "Thank you, " + txtName.getText() +" The total cost of the price is £" +
                        String.format("%.2f", price) +  " " +
                        lstBranch.getSelectionModel().getSelectedItem() + " will deliver"
        );
    }
}