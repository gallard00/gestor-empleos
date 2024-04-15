package com.example.empleos.Dtos;

import lombok.Data;

@Data
public class EmpleoRequest {
    private String titulo;
    private String descripcion;
    private double salario;
    private boolean disponible;
}
