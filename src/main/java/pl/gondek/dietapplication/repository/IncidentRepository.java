package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Incident;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findAllByUser_UserId(Long id);
}
