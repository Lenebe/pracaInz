package pl.gondek.dietapplication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.SecurityRepository;
import pl.gondek.dietapplication.repository.UserRepository;

@Component
public class SignInHelper {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Context context;

    public boolean shouldBeLogged(Security security)
    {
        String providedPassword = security.getPassword();
        Security securityFromDB = securityRepository.findByLogin(security.getLogin());

        if (securityFromDB != null)
        {
            User user = userRepository.findBySecurity_SecurityId(securityFromDB.getSecurityId());

            String passwordFromDB = securityFromDB.getPassword();
            String saltFromDB = securityFromDB.getSalt();

            if (PasswordUtils.verifyUserPassword(providedPassword, passwordFromDB, saltFromDB))
            {
                context.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }
}
