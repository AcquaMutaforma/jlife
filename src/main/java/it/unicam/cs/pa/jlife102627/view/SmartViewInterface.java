package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.rules.RulesManagerInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SmartViewInterface{

    /**
     * chiede all'utente il tipo di griglia che si vuole costruire
     */
    String getBoardType() throws IOException;

    /**
     * Chiede il tipo di regole da applicare alla smart cell
     */
    HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException;


}
