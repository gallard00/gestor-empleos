package com.example.empleos.Models;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

@Table(name = "equipo")
@Entity
@Getter
@Setter
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private int partidos;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int golesFavor;
    private int golesContra;
    private int diferencia;
    private int puntos;

    @ManyToOne
    @JoinColumn(name = "liga_id", nullable = false)
    private Liga liga;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;
}
