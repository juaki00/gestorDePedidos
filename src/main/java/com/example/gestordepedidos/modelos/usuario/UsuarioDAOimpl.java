package com.example.gestordepedidos.modelos.usuario;

import com.example.db.Database;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;

@Data
public class UsuarioDAOimpl implements UsuarioDAO {

    private Connection connection = (new Database().getConnection());
    private final String QUERYLOADALL = "SELECT * FROM usuario";
    private final String QUERYLOADLOGIN = "SELECT * FROM usuario WHERE nombre = ? and pass = ?";

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

    public boolean isCorrectUser(String user, String pass) throws NullPointerException{
        boolean salida = false;
        try(PreparedStatement pst = connection.prepareStatement(QUERYLOADLOGIN)){
            pst.setString(1,user);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                salida=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Runtime Exception");
        }
        return salida;
    }

    @Override
    public Usuario loadLogin(String user, String pass) {
        Usuario usuario = new Usuario();
        try(PreparedStatement pst = connection.prepareStatement(QUERYLOADLOGIN)){
            pst.setString(1,user);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
