package com.example.gestordepedidos.modelos.pedido;

import com.example.db.Database;
import com.example.gestordepedidos.modelos.item.Item;
import com.example.gestordepedidos.modelos.usuario.Usuario;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class PedidoDAOImpl implements PedidoDAO {

    private final Connection connection = (new Database().getConnection());
    private final String QUERYLOADPEDIDOSDEUSUARIO = "SELECT * FROM pedido WHERE usuario = ?";
    private final String QUERYDETALLESDEUNPEDIDO = "SELECT producto.nombre,item.cantidad,producto.precio,fecha FROM (" +
            "(pedido INNER JOIN item ON pedido.id = item.id_pedido)" +
            " INNER JOIN producto ON producto.id = item.id_producto)" +
            " INNER JOIN usuario ON usuario.id = pedido.usuario" +
            " WHERE pedido.id = ?";
    private final String QUERYSUMATOTALDEUNPEDIDO = "SELECT SUM(item.cantidad * producto.precio) AS suma FROM " +
            "(pedido INNER JOIN item ON pedido.id = item.id_pedido)" +
            " INNER JOIN producto ON producto.id = item.id_producto" +
            " WHERE pedido.id = ?";
    @Override
    public Pedido load(Long id) {
        return null;
    }

    @Override
    public ArrayList<Pedido> loadAll() {
        return null;
    }

    @Override
    public ArrayList<Pedido> pedidosDeUnUsuario(Usuario user) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(QUERYLOADPEDIDOSDEUSUARIO)) {
            pst.setInt(1,user.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setCodigo(rs.getString("codigo"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setUsuarioId(rs.getInt("usuario"));
                pedido.setTotal(this.sumaTotalDeUnPedido(pedido.getId()));
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }

    public ArrayList<Item> detallesDeUnPedido(Pedido pedido) {
        ArrayList<Item> items = new ArrayList<>();
        Item item;
        try (PreparedStatement pst = connection.prepareStatement(QUERYDETALLESDEUNPEDIDO)) {
            pst.setInt(1, pedido.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                item = new Item();
                item.setNombre(rs.getString("nombre"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecio(rs.getDouble("precio"));
                item.setFecha(rs.getString("fecha"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public String sumaTotalDeUnPedido(int idPedido){
        double resultado = 0.0;
        try (PreparedStatement pst = connection.prepareStatement(QUERYSUMATOTALDEUNPEDIDO)) {
            pst.setInt(1, idPedido);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                resultado = rs.getDouble("suma");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DecimalFormat formato = new DecimalFormat("#.00");
        String redondeado = formato.format(resultado);
        System.out.println("numero: "+resultado + "redondeado: "+redondeado);
        return redondeado;
    }
}

