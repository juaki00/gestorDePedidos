package com.example.gestordepedidos;

import com.example.gestordepedidos.pedido.PedidoDAO;
import com.example.gestordepedidos.pedido.PedidoDAOImpl;
import com.example.gestordepedidos.usuario.Usuario;
import com.example.gestordepedidos.usuario.UsuarioDAOimpl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class MainAplication extends Application {

    @Getter
    @Setter
    private static Stage myStage;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 370, 440);
        myStage = stage;
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static void loadFXML(String fxml){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            myStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo "+fxml);
            throw new RuntimeException(e);
        }

    }

}