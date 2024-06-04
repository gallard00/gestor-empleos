package com.example.empleos.Models;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

@Entity
@Table(name = "jugador")
@Setter
@Getter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String apellido;
    private String posicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;
}
