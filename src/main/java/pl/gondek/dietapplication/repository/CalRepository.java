package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Cal;
import pl.gondek.dietapplication.model.Meal;

import java.util.List;

public interface CalRepository extends JpaRepository<Cal, Long> {

//    User findBySecurity_SecurityId(Long id);

    List<Cal> findAllByUser_UserId(Long id);


}
