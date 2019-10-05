package pl.gondek.dietapplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Pollen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pollen_id;

    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate stop;

    public long getPollen_id()
    {
        return pollen_id;
    }

    public void setPollen_id(long pollen_id)
    {
        this.pollen_id = pollen_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getStart()
    {
        return start;
    }

    public void setStart(LocalDate start)
    {
        this.start = start;
    }

    public LocalDate getStop()
    {
        return stop;
    }

    public void setStop(LocalDate stop)
    {
        this.stop = stop;
    }
}
