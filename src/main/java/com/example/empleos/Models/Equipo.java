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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liga_id", nullable = false)
    private Liga liga;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Partido> partidosLocal = new HashSet<>();

    @OneToMany(mappedBy = "equipoVisitante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Partido> partidosVisitante = new HashSet<>();
}
