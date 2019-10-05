package pl.gondek.dietapplication.finder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Pollen;
import pl.gondek.dietapplication.repository.PollenRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CrossAllergyFinderTest {

    @InjectMocks
    private CrossAllergyFinder underTest;
    @Mock
    private PollenRepository pollenRepository;

    @Test
    public void shouldFindCrossAllergy()
    {
        // given
        List<Pollen> pollenList = createPollenList();

        Incident incident = new Incident();
        incident.setReaction("vomiting");
        incident.setStart(LocalDate.of(2019, 8, 15));

        Mockito.when(pollenRepository.findAll()).thenReturn(pollenList);

        // when
        List<Pollen> crossAllergy = underTest.findCrossAllergy(incident);

        // then
        Assert.assertEquals(crossAllergy.get(0).getName(), "B");
    }

    private List<Pollen> createPollenList()
    {
        return Arrays.asList(
                createPollen("A", LocalDate.of(2019, 5, 1),
                        LocalDate.of(2019, 5, 30)),
                createPollen("B", LocalDate.of(2019, 8, 1),
                        LocalDate.of(2019, 8, 30)));
    }

    private Pollen createPollen(String name, LocalDate start, LocalDate stop)
    {
        Pollen pollen = new Pollen();

        pollen.setName(name);
        pollen.setStart(start);
        pollen.setStop(stop);

        return pollen;
    }
}