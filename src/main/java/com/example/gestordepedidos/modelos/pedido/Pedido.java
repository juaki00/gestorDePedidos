package com.example.gestordepedidos.modelos.pedido;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    private Integer id;
    private String codigo;
    private String fecha;
    private Integer usuarioId;
    private String total;

    public Pedido(int id){
        this.id=id;
    }
}
