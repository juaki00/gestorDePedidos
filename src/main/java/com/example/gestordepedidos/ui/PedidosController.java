package com.example.gestordepedidos.ui;

import com.example.gestordepedidos.MainAplication;
import com.example.gestordepedidos.modelos.usuario.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PedidosController implements Initializable {
    @javafx.fxml.FXML
    private Button btnLogout;
    @javafx.fxml.FXML
    private Label labelNombre;
    @javafx.fxml.FXML
    private TableView tablaPedidos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario user = Usuario.usuarioSesion;

        labelNombre.setText("Pedidos de "+user.getNombre()+" ("+user.getEmail()+")");
    }

    @javafx.fxml.FXML
    public void logoutButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/login-view.fxml"));
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 350, 450);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }


}
