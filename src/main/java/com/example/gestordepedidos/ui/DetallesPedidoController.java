package com.example.gestordepedidos.ui;

import com.example.gestordepedidos.modelos.producto.Producto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetallesPedidoController implements Initializable
{

    @FXML
    private TableView<Producto> tablaDetallesPedido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    tablaDetallesPedido.getSelectionModel().selectedItemProperty().addListener((observableValue, vOld, vNew) -> {

    //    info.setText(vNew.toString());
    //    txtNombre.setText(vNew.getNombre());
    //    sliderDuracion.setValue(vNew.getDuracion());
    //    listTipo.getSelectionModel().select( vNew.getTipo());
    //    comboDificultad.getSelectionModel().select(vNew.getDificultad());
    });
}
}