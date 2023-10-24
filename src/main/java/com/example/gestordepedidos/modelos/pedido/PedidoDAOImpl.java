package com.example.gestordepedidos.modelos.pedido;

import com.example.db.Database;
import com.example.gestordepedidos.modelos.usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;


public class PedidoDAOImpl implements PedidoDAO {

    private Connection connection = (new Database().getConnection());
    private final String QUERYLOADPEDIDOSDEUSUARIO = "SELECT * FROM pedido WHERE usuario = ?";

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
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try (PreparedStatement pst = connection.prepareStatement(QUERYLOADPEDIDOSDEUSUARIO)) {
            pst.setInt(1,user.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setCodigo(rs.getString("codigo"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setUsuarioId(rs.getInt("usuario"));
                pedido.setTotal(rs.getDouble("total"));
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }
}
