package com.example.gestordepedidos.ui;

import com.example.gestordepedidos.modelos.item.Item;
import com.example.gestordepedidos.modelos.pedido.Pedido;
import com.example.gestordepedidos.modelos.pedido.PedidoDAOImpl;
import com.example.gestordepedidos.modelos.producto.Producto;
import com.example.sesion.Sesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetallesPedidoController implements Initializable
{

    @FXML
    private TableView<Item> tablaDetallesPedido;
    @FXML
    private TableColumn<Item,String>  cNombre;
    @FXML
    private TableColumn<Item,String>  cPrecio;
    @FXML
    private TableColumn<Item,String>  cCantidad;
    @FXML
    private TableColumn<Item,String> cFecha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



       PedidoDAOImpl dao = new PedidoDAOImpl();
        ArrayList<Item> items = dao.detallesDeUnPedido(Sesion.getPedidoPulsado());

        //Rellenar la tabla
        cNombre. setCellValueFactory( (fila) -> {
            String nombre = fila.getValue().getNombre();
            return new SimpleStringProperty(nombre);
        });
        cCantidad. setCellValueFactory( (fila) -> {
            int cantidad = fila.getValue().getCantidad();
            return new SimpleStringProperty(cantidad,toString());
        });
        cPrecio. setCellValueFactory( (fila) -> {
            double precio = fila.getValue().getPrecio();
            return new SimpleStringProperty(Double.toString(precio));
        });
        cFecha. setCellValueFactory( (fila) -> {
            String fecha = fila.getValue().getFecha();
            return new SimpleStringProperty(fecha);
        });
        ObservableList<Item> observableList = FXCollections.observableArrayList();
        observableList.addAll(items);
        tablaDetallesPedido.setItems(observableList);


}
}