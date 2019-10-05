package pl.gondek.dietapplication.utils;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.User;

@Component
public class Context {

    private User currentUser;

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }
}
