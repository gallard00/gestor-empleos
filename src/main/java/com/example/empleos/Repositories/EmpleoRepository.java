package com.example.empleos.Repositories;

    import com.example.empleos.Models.Empleo;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long> {
}
