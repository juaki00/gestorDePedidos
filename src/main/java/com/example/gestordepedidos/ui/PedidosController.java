package com.example.gestordepedidos.ui;

import com.example.gestordepedidos.MainAplication;
import com.example.gestordepedidos.modelos.pedido.Pedido;
import com.example.gestordepedidos.modelos.pedido.PedidoDAOImpl;
import com.example.gestordepedidos.modelos.usuario.Usuario;
import com.example.gestordepedidos.modelos.usuario.UsuarioDAOimpl;
import com.example.sesion.Sesion;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PedidosController implements Initializable {
    @javafx.fxml.FXML
    private Label labelNombre;
    @javafx.fxml.FXML
    private TableView<Pedido> tablaPedidos;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> cId;

    @javafx.fxml.FXML
    private TableColumn<Pedido,String> cCodigo;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> cFecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> cUsuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido,String> cTotal;
    @javafx.fxml.FXML
    private Button btnLogout;
    @javafx.fxml.FXML
    private Pane mainPedidos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        tablaPedidos.getSelectionModel().selectedItemProperty().addListener((observableValue, vOld, vNew) -> {
            MainAplication.loadFXML("detallesPedido-view.fxml");
        });



        Usuario user = Sesion.getUsuarioActual();
        PedidoDAOImpl daoPedido = new PedidoDAOImpl();
        List<Pedido> pedidosDeUser = daoPedido.pedidosDeUnUsuario(user);

        //Rellenar la tabla
        cId.setCellValueFactory( (fila) -> {
            Integer id = fila.getValue().getId();
            return new SimpleStringProperty(id.toString());
        });
        cCodigo.setCellValueFactory( (fila) -> {
            String cod = fila.getValue().getCodigo();
            return new SimpleStringProperty(cod);
        });
        cFecha.setCellValueFactory( (fila) ->{
            String cantidad = fila.getValue().getFecha();
            return new SimpleStringProperty(cantidad);
        });
        cUsuario.setCellValueFactory( (fila) ->{
            Integer idUsuario = fila.getValue().getUsuarioId();
            String nombre = Sesion.getUsuarioActual().getNombre();
            return new SimpleStringProperty(nombre);
        });
        cTotal.setCellValueFactory( (fila) -> {
            Double total = fila.getValue().getTotal();
            return new SimpleStringProperty(total.toString());
        });


        tablaPedidos.getItems().addAll(pedidosDeUser);

        labelNombre.setText("Pedidos de "+user.getNombre()+" ("+user.getEmail()+")");
    }

    @javafx.fxml.FXML
    public void logoutButton() {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainAplication.class.getResource("ui/login-view.fxml"));
//        Stage stage = (Stage) btnLogout.getScene().getWindow();
//        Scene scene = null;
//        try {
//            scene = new Scene(fxmlLoader.load(), 350, 450);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//        stage.setTitle("Login");
//        stage.setScene(scene);
//        stage.show();
        MainAplication.loadFXML("login-view.fxml");
    }



}
