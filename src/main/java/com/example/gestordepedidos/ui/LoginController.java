package com.example.gestordepedidos.ui;
import com.example.gestordepedidos.MainAplication;
import com.example.gestordepedidos.usuario.UsuarioDAO;
import com.example.gestordepedidos.usuario.UsuarioDAOimpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;


@Data
public class LoginController {

    @FXML
    private TextField tfUsuario;
    @FXML
    private Button btnEntrar;
    @FXML
    private PasswordField tfPass;
    @FXML
    private Label info;

    @FXML
        private void btnEntrar(){
        UsuarioDAO dao = new UsuarioDAOimpl();

        if(dao.isCorrectUser(tfUsuario.getText(),tfPass.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/pedidos-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 370, 440);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        else{
            tfUsuario.setText("");
            tfPass.setText("");
            info.setText("Nombre de usuario o contraseña incorrecto(s)");
        }

    }
}