package com.example.empleos.Repositories;

    import com.example.empleos.Models.Candidato;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

@Repository

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
