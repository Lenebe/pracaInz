package pl.gondek.dietapplication.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long incident_id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    private String reaction;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getReaction()
    {
        return reaction;
    }

    public void setReaction(String reaction)
    {
        this.reaction = reaction;
    }

    public LocalDate getStart()
    {
        return start;
    }

    public void setStart(LocalDate start)
    {
        this.start = start;
    }

    public long getIncident_id()
    {
        return incident_id;
    }

    public void setIncident_id(long incident_id)
    {
        this.incident_id = incident_id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }


}
