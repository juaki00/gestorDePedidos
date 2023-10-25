package com.example.gestordepedidos.modelos.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    private int id;
    private String nombre;
    private String pass;
    private String email;


}
