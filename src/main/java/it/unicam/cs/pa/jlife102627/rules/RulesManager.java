package it.unicam.cs.pa.jlife102627.rules;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Gestisce le leggi di vita e morte delle SmartCell.
 */
public class RulesManager implements RulesManagerInterface{


    @Override
    public List<String> getAvailableRules() {
        List<String> available = new ArrayList<>();
        available.add("default");
        //avaialable.add("zombie");
        return available;
    }

    /**
     * Default: se una cellula ha meno di 2 o piu di 3 vicini vivi, muore
     * se una cellula morta ha 3 vicini vivi, allora vive
     * @return Default rules of game of life
     */
    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getDefaultRules() {
        HashMap<Predicate<Integer>, Consumer<CellInterface>> r = new HashMap<>();
        r.put(x -> x > 3 || x < 2, y -> y.setState(false));
        r.put( x -> x == 3, y -> y.setState(true));
        return r;
    }

    //TODO EHEH non so che metterci per rendere l'idea di qualcosa di personalizzabile
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getZombieRules() {
        HashMap<Predicate<Integer>, Consumer<CellInterface>> r = new HashMap<>();
        r.put(x -> x > 3 || x < 2, y -> y.setState(false));
        r.put( x -> x == 3, y -> y.setState(true));
        return r;
    }

    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules(String s) {
        switch (s){
            case "zombie": return getZombieRules();
            default: return  getDefaultRules();
        }
    }


}
