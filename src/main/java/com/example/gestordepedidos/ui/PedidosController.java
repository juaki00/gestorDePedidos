package com.example.gestordepedidos.ui;

import com.example.gestordepedidos.MainAplication;
import com.example.gestordepedidos.modelos.pedido.Pedido;
import com.example.gestordepedidos.modelos.pedido.PedidoDAOImpl;
import com.example.gestordepedidos.modelos.usuario.Usuario;
import com.example.sesion.Sesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
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
    private Pane mainPedidos;
    @javafx.fxml.FXML
    private Button btnLogout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        tablaPedidos.getSelectionModel().selectedItemProperty().addListener((observableValue, vOld, vNew) -> {
            Sesion.setPedidoPulsado(vNew);
            MainAplication.loadFXML("detallesPedido-view.fxml", "Detalles del pedido");
        });



        Usuario user = Sesion.getUsuarioActual();
        PedidoDAOImpl daoPedido = new PedidoDAOImpl();
        List<Pedido> pedidosDeUser = daoPedido.pedidosDeUnUsuario(user) ;



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
            String nombre = Sesion.getUsuarioActual().getNombre();
            return new SimpleStringProperty(nombre);
        });
        cTotal.setCellValueFactory( (fila) -> {
            String total = fila.getValue().getTotal();
            return new SimpleStringProperty(total);
        });


        tablaPedidos.getItems().addAll(pedidosDeUser);

        labelNombre.setText("Pedidos de "+user.getNombre()+" ("+user.getEmail()+")");
    }

    @javafx.fxml.FXML
    public void logoutButton() {
        Sesion.setUsuarioActual(null);
        Sesion.setPedidoPulsado(null);
        MainAplication.loadFXML("login-view.fxml", "Iniciar Sesión");
    }



}
