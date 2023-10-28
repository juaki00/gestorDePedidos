package com.example.gestordepedidos.modelos.item;

import lombok.Data;

@Data
public class Item {
    private String nombre;
    private Integer cantidad ;
    private Double precio;
    private String fecha;
}
