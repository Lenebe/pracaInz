package pl.gondek.dietapplication.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Pollen;
import pl.gondek.dietapplication.repository.PollenRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrossAllergyFinder {

    @Autowired
    private PollenRepository pollenRepository;

    public List<Pollen> findCrossAllergy(Incident incident)
    {
        return pollenRepository.findAll().stream()
                .filter(pollen -> pollen.getStart().isBefore(incident.getStart()))
                .filter(pollen -> pollen.getStop().isAfter(incident.getStart()))
                .collect(Collectors.toList());
    }


}
