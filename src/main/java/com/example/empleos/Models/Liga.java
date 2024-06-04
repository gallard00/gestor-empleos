package com.example.empleos.Models;
    import jakarta.persistence.*;
    import lombok.*;


    import java.util.List;

@Entity
@Table(name = "liga")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "liga")
    private List<Equipo> equipos;
}
