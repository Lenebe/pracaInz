package pl.gondek.dietapplication.defaults;

import pl.gondek.dietapplication.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodList {

    private List<Food> foods;
    private List<String> str = new ArrayList<>();

    public FoodList()
    {
        this.foods = Arrays.asList(new Food("potatoes with pork chop"), new Food("eggs"), new Food("nuts"), new Food("seafood"), new Food("soy"));
        this.str.add("strZiemniak");
        this.str.add("strMleko");

    }

    public List<Food> getFoods()
    {
        return foods;
    }

    public List<String> getStr()
    {
        return str;
    }
}
