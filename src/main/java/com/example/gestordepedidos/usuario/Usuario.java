package com.example.gestordepedidos.usuario;

import lombok.Data;


@Data
public class Usuario {
    private int id;
    private String nombre;
    private String pass;
    private String email;
}
