package com.example.sesion;

import com.example.gestordepedidos.modelos.usuario.Usuario;
import com.example.gestordepedidos.modelos.pedido.Pedido;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;


@Data
public class Sesion {

    @Setter
    @Getter
    private static Usuario usuarioActual;

    @Setter
    @Getter
    private static Pedido pedidoPulsado;





}
