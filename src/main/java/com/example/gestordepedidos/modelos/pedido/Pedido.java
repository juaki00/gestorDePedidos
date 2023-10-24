package com.example.gestordepedidos.modelos.pedido;

import java.util.Date;

import lombok.Data;


@Data
public class Pedido {

    private int id;
    private String codigo;
    private Date fecha;
    private int usuarioId;
    private int total;
}
