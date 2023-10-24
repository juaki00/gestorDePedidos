package com.example.gestordepedidos.modelos.pedido;

import com.example.gestordepedidos.modelos.usuario.Usuario;

import java.util.ArrayList;

public interface PedidoDAO {
    public Pedido load(Long id);
    public ArrayList<Pedido> loadAll();
    public ArrayList<Pedido> pedidosDeUnUsuario(Usuario user);
}
