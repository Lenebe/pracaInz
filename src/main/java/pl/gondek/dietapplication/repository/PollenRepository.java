package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Pollen;

public interface PollenRepository extends JpaRepository<Pollen, Long> {

}