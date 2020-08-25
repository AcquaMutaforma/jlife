package it.unicam.cs.pa.jlife102627.rules;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Ha la responsabilita' di gestire le regole delle SmartCell.
 */
public interface RulesManagerInterface {

    List<String> getAvailableRules();

    HashMap<Predicate<Integer>, Consumer<CellInterface>> getDefaultRules();
}
