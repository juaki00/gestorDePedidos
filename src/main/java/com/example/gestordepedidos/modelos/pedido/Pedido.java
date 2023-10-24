package com.example.gestordepedidos.modelos.pedido;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    private int id;
    private String codigo;
    private String fecha;
    private int usuarioId;
    private Double total;
}
