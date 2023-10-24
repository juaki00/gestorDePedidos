package com.example.sesion;

import com.example.gestordepedidos.modelos.usuario.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Sesion {

    @Setter
    @Getter
    private static Usuario usuarioActual;


}
