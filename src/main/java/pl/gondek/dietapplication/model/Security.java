package pl.gondek.dietapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "SECURITY")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECURITY_ID")
    private long securityId;

    private String login;
    private String password;
    private String salt;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @OneToOne(mappedBy = "security")
    private User user;


    public long getSecurityId()
    {
        return securityId;
    }

    public void setSecurityId(long securityId)
    {
        this.securityId = securityId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }
}
