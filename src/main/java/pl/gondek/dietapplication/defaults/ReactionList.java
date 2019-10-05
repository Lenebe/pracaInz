package pl.gondek.dietapplication.defaults;

import pl.gondek.dietapplication.model.Reaction;

import java.util.Arrays;
import java.util.List;

public class ReactionList {

    private List<Reaction> reactions;

    public ReactionList()
    {
        this.reactions = Arrays.asList(new Reaction("diarrhea"), new Reaction("vomiting"), new Reaction("skin reaction"));

    }

    public List<Reaction> getReactions()
    {
        return reactions;
    }

}
