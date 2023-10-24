package com.example.gestordepedidos.modelos.usuario;

import lombok.Data;


@Data
public class Usuario {
    private int id;
    private String nombre;
    private String pass;
    private String email;
}
