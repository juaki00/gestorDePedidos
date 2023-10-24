package com.example.gestordepedidos.ui;
import com.example.gestordepedidos.MainAplication;
import com.example.gestordepedidos.usuario.Usuario;
import com.example.gestordepedidos.usuario.UsuarioDAO;
import com.example.gestordepedidos.usuario.UsuarioDAOimpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Data
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsuario;
    @FXML
    private Button btnEntrar;
    @FXML
    private PasswordField tfPass;
    @FXML
    private Label info;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
        private void btnEntrar() {
        UsuarioDAO dao = new UsuarioDAOimpl();
        try{
            if (dao.isCorrectUser(tfUsuario.getText(), tfPass.getText())) {
                Usuario.usuarioSesion = dao.loadLogin(tfUsuario.getText(), tfPass.getText());
                FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/pedidos-view.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 800, 600);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                Stage stage = (Stage) btnEntrar.getScene().getWindow();
                Stage stage = MainAplication.getMyStage();
                stage.setTitle("Pedidos");
                stage.setScene(scene);
                stage.show();
            } else {
                tfUsuario.setText("");
                tfPass.setText("");
                info.setText("Nombre de usuario o contraseña incorrecto(s)");
            }

        } catch (NullPointerException e){
            info.setText("Error de conexion con la base de datos");
        }
    }


}