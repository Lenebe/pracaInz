package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.processor.SignUpProcessor;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.utils.SignInHelper;
import pl.gondek.dietapplication.utils.SignUpHelper;

@Controller
public class RegisterAndLoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SignInHelper signInHelper;
    @Autowired
    private SignUpHelper signUpHelper;

    @Autowired
    private SignUpProcessor signUpProcessor;


    @GetMapping("/signUp")
    public String signUpGet(Model model)
    {

        model.addAttribute("security", new Security());

        return "registerAndLogin/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@ModelAttribute Security security, Model model)
    {

        model.addAttribute("user", new Security());
        return signUpProcessor.signUp(security);

    }

    @PostMapping("/signIn")
    public String signInPost(@ModelAttribute Security userForLogin, Model model)
    {
        if (signInHelper.shouldBeLogged(userForLogin))
        {
            return "signIn/userPage";
        } else
        {
            model.addAttribute("user", new Security());
            return "registerAndLogin/login";
        }

    }


}
