package com.example.gestordepedidos.modelos.item;

import lombok.Data;

@Data
public class Item {
    private String nombre;
    private int cantidad ;
    private double precio;
    private String fecha;
}
