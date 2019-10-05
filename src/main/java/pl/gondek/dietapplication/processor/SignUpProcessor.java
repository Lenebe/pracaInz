package pl.gondek.dietapplication.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.utils.Context;
import pl.gondek.dietapplication.utils.PasswordUtils;
import pl.gondek.dietapplication.utils.SignUpHelper;

import java.util.Objects;

@Component
public class SignUpProcessor {

    @Autowired
    private SignUpHelper signUpHelper;
    @Autowired
    private Context context;

    public String signUp(Security userToSignUp)
    {
        User security = signUpHelper.getSecurityByLogin(userToSignUp.getLogin());
        if (Objects.isNull(security))
        {
            String salt = PasswordUtils.getSalt(30);

            // Protect user's password. The generated value can be stored in DB.
            String mySecurePassword = PasswordUtils.generateSecurePassword(userToSignUp.getPassword(), salt);

            userToSignUp.setPassword(mySecurePassword);
            userToSignUp.setSalt(salt);

            signUpHelper.register(userToSignUp);
            return "registerAndLogin/login";
        } else
        {

            return "registerAndLogin/signUp";
        }


    }

}
