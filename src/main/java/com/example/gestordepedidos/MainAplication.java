package com.example.gestordepedidos;

import com.example.gestordepedidos.modelos.pedido.Pedido;
import com.example.gestordepedidos.modelos.pedido.PedidoDAOImpl;
import com.example.gestordepedidos.modelos.usuario.Usuario;
import com.example.sesion.Sesion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class MainAplication extends Application {


    private static Stage myStage;
    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/login-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static void loadFXML(String fxml){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/"+fxml));
            System.out.println("ui/"+fxml);
            Scene scene = new Scene(fxmlLoader.load());
            myStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo "+fxml);
            throw new RuntimeException(e.getStackTrace().toString());
        }

    }

}