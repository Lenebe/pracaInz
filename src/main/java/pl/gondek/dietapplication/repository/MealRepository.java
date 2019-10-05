package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.model.User;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

//    User findBySecurity_SecurityId(Long id);

    List<Meal> findAllByUser_UserId(Long id);


}
