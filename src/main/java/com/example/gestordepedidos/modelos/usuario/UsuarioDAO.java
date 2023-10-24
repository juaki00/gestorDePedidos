package com.example.gestordepedidos.modelos.usuario;

import java.util.ArrayList;

public interface UsuarioDAO {
    public Usuario load(Long id);
    public ArrayList<Usuario> loadAll();
    public boolean isCorrectUser(String user, String pass);
    public Usuario loadLogin(String user,String pass);
}
