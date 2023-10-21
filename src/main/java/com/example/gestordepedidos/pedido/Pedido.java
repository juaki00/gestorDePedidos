package com.example.gestordepedidos.pedido;

import lombok.Data;

import java.util.Date;

@Data
public class Pedido {

    private int id;
    private String codigo;
    private Date fecha;
    private int usuarioId;
    private int total;
}
