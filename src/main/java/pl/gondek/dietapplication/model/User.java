package pl.gondek.dietapplication.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private double bmi;
    private double bmr;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SECURITY_ID", referencedColumnName = "SECURITY_ID")
    private Security security;


    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user")
    private Set<Meal> meals;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user")
    private Set<Incident> incidents;


    public Security getSecurity()
    {
        return security;
    }

    public void setSecurity(Security security)
    {
        this.security = security;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getBmi()
    {
        return bmi;
    }

    public void setBmi(double bmi)
    {
        this.bmi = bmi;
    }

    public double getBmr()
    {
        return bmr;
    }

    public void setBmr(double bmr)
    {
        this.bmr = bmr;
    }

    public Set<Meal> getMeals()
    {
        return meals;
    }

    public void setMeals(Set<Meal> meals)
    {
        this.meals = meals;
    }

    public Set<Incident> getIncidents()
    {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents)
    {
        this.incidents = incidents;
    }
}
