package com.example.gestordepedidos;

import com.example.db.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Database db = new Database();
        Connection con = db.getConnection();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}