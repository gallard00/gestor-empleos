package com.example.empleos.Models;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;
    import java.util.HashSet;
    import java.util.Set;

@Table(name = "Candidato")
@Entity
@Getter
@Setter

public class Candidato {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String Email;
    // Relación bidireccional con Empleo
    @ManyToMany(mappedBy = "candidatos", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<Empleo> empleos = new HashSet<>();
}
