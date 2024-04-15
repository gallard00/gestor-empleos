package com.example.empleos.Dtos;

import lombok.Data;

@Data
public class EmpleoResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private double salario;
    private boolean disponible;
}
