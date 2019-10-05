package pl.gondek.dietapplication.utils;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Meal;

import java.time.LocalDate;
import java.util.*;

@Component
public class AllergensFinder {

    public List<Meal> findAllergens(List<Meal> meals, List<Incident> incidents)
    {
        List<Meal> results = new ArrayList<>();

        Optional<Incident> lastIncident = incidents.stream().max(Comparator.comparing(Incident::getStart));

        if(!lastIncident.isPresent())
        {
            return Collections.emptyList();
        }

        LocalDate incidentStart = lastIncident.get().getStart();

        Optional<Meal> max = meals.stream()
                .filter(meal -> meal.getStart().isBefore(incidentStart))
                .filter(meal -> incidentStart.minusDays(3).isBefore(meal.getStart()))
                .max(Comparator.comparing(Meal::getStart));


        results.add(max.get());

        return results;
    }


//        temporaryMealRepository.getMeals().stream()
//                .peek(meal -> (temporaryIncydentRepository.getIncidents().stream().map(Incident::getStart).filter(date -> date.after(meal.getStart())));

//        temporaryMealRepository.getMeals().stream().map(Meal::getStart)
//                .filter(date -> (temporaryIncydentRepository.getIncidents().stream().map(Incident::getStart).filter(date -> date.equals(date)))


}
