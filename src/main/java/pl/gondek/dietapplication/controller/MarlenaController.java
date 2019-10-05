package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.defaults.ReactionList;
import pl.gondek.dietapplication.model.Cal;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.CalRepository;
import pl.gondek.dietapplication.repository.IncidentRepository;
import pl.gondek.dietapplication.repository.MealRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.utils.AllergensFinder;
import pl.gondek.dietapplication.utils.Context;

import java.util.List;
import java.util.Set;

@Controller
public class MarlenaController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CalRepository calRepository;
    @Autowired
    private Context context;


    @GetMapping("/addPersonalData")
    public String addPersonalDataGet(Model model)
    {
        model.addAttribute("user", new User());

        return "addPersonalData";
    }

    @PostMapping("/addPersonalData")
    public String addPersonalDataPost(@ModelAttribute User user, Model model)
    {
        model.addAttribute("user", new User());

        User currentUser = this.context.getCurrentUser();

        currentUser.setName(user.getName());
        currentUser.setGender(user.getGender());
        currentUser.setAge(user.getAge());
        currentUser.setWeight(user.getWeight());
        currentUser.setHeight(user.getHeight());

        currentUser.setBmi(obliczBmi(user.getHeight(), user.getWeight()));
        currentUser.setBmr(user.getWeight() * user.getHeight());

        userRepository.save(currentUser);


        return "signIn/userPage";
    }

    @GetMapping("/addCal")
    public String addCal(Model model)
    {
        model.addAttribute("cal", new Cal());

        return "addCal";
    }

    @PostMapping("/addCal")
    public String addPersonalDataPost(@ModelAttribute Cal cal, Model model)
    {

        User currentUser = context.getCurrentUser();

        cal.setUser(currentUser);

        calRepository.save(cal);


        return "signIn/userPage";
    }

    @GetMapping("/showCal")
    public String showCal(Model model)
    {

        List<Cal> allByUser_userId = calRepository.findAllByUser_UserId(context.getCurrentUser().getUserId());

        model.addAttribute("calAll", allByUser_userId);

        return "showCal";
    }

    @PostMapping("/showCal")
    public String showCalPost(@ModelAttribute Cal cal, Model model)
    {

        User currentUser = context.getCurrentUser();

        cal.setUser(currentUser);

        calRepository.save(cal);


        return "signIn/userPage";
    }

    private double obliczBmi(double height, double weight)
    {
        return weight/(height*height);

    }


}
