package com.example.empleos.Models;
    import jakarta.persistence.*;
    import lombok.Setter;
    import lombok.Getter;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

@Table(name = "liga")
@Entity
@Getter
@Setter
public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "liga", cascade = CascadeType.ALL)
    private List<Equipo> equipos;

}
