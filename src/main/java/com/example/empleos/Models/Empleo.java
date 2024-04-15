package com.example.empleos.Models;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

@Table(name = "Empleo")
@Entity
@Getter
@Setter
public class Empleo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String titulo;
    private String descripcion;
    private double salario;
    private boolean disponible;
}
