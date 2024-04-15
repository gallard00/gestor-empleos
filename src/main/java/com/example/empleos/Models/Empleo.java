package com.example.empleos.Models;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;
    import java.util.HashSet;
    import java.util.Set;
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
    // Relación con Candidato
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "empleo_candidato",
            joinColumns = @JoinColumn(name = "empleo_id"),
            inverseJoinColumns = @JoinColumn(name = "candidato_id")
    )
    private Set<Candidato> candidatos = new HashSet<>();
}
