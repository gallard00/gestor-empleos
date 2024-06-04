package com.example.empleos.Models;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.Date;

@Table(name = "partido")
@Entity
@Getter
@Setter
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    private int golesLocal;
    private int golesVisitante;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liga_id", nullable = false)
    private Liga liga;
}
