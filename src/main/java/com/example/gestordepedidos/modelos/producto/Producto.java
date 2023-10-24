package com.example.gestordepedidos.modelos.producto;

import lombok.Data;

@Data
public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
}
