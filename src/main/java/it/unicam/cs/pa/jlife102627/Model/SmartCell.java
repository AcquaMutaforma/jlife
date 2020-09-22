package it.unicam.cs.pa.jlife102627.Model;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ha la responsabilita' di simulare una cellula. La differenza tra questa e la Cell e' come
 * gestisce le regole di vita.
 */
public class SmartCell extends Cell{

    private transient HashMap<Predicate<Integer>,Consumer<CellInterface>> rules;

    public SmartCell(boolean state, HashMap<Predicate<Integer>,Consumer<CellInterface>> r) {
        super(state);
        this.rules = r;
    }

    @Override
    public void live(int n){
        if(rules == null)
            throw new NullPointerException();
        for(Predicate<Integer> p : rules.keySet()){
            if(p.test(n)) {
                rules.get(p).accept(this);
                return;
            }
        }
    }

    public void setRules(HashMap<Predicate<Integer>,Consumer<CellInterface>> r){
        this.rules = r;
    }

    public HashMap<Predicate<Integer>,Consumer<CellInterface>> getRules(){
        return this.rules;
    }
}
