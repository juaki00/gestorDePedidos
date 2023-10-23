package com.example.gestordepedidos.usuario;

import com.example.db.Database;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAOimpl implements UsuarioDAO {

    private Connection connection = (new Database().getConnection());

    private final String QUERYLOADALL = "SELECT * FROM usuario";

    private final String QUERYLOADONE = "SELECT * FROM usuario WHERE nombre = ? and pass = ?";

    @Override
    public Usuario load(Long id) {
        return null;
    }

    @Override
    public ArrayList<Usuario> loadAll() {
        var salida = new ArrayList<Usuario>();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(QUERYLOADALL);

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setPass(rs.getString("pass"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNombre(rs.getString("nombre"));
                salida.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    public boolean isCorrectUser(String user, String pass) {
        boolean salida = false;
        try(PreparedStatement pst = connection.prepareStatement(QUERYLOADONE)){
            pst.setString(1,user);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                salida=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;



    }
}
