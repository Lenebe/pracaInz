package pl.gondek.dietapplication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.SecurityRepository;
import pl.gondek.dietapplication.repository.UserRepository;

@Component
public class SignUpHelper {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private UserRepository userRepository;

    public User getSecurityByLogin(String login)
    {
        Security byLogin = securityRepository.findByLogin(login);

        if (byLogin != null)
        {
//            User s1 = userRepository.findBySecurity_SecurityId(byLogin.getSecurityId());
            User s2 = userRepository.findBySecurity_SecurityId(Long.valueOf(byLogin.getSecurityId()));

//            User s3 = userRepository.findBySecurityId(String.valueOf(byLogin.getSecurityId()));
//            User s4 = userRepository.findBySecurityId(byLogin.getSecurityId());

            return s2;
        } else
        {
            return null;
        }

    }


    public void register(Security userToSignUp)
    {
        User user = new User();

        user.setSecurity(userToSignUp);

        userRepository.save(user);
    }
}
