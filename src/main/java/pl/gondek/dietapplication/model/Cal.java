package pl.gondek.dietapplication.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Cal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cal_id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    private double cal;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public long getCal_id()
    {
        return cal_id;
    }

    public void setCal_id(long cal_id)
    {
        this.cal_id = cal_id;
    }

    public LocalDate getStart()
    {
        return start;
    }

    public void setStart(LocalDate start)
    {
        this.start = start;
    }

    public double getCal()
    {
        return cal;
    }

    public void setCal(double cal)
    {
        this.cal = cal;
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
