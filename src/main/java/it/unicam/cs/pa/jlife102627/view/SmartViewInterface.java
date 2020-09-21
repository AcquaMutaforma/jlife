package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Ha la responsabilità di gestire gli input e output legati ai componenti Smart.
 */
public interface SmartViewInterface{

    /** Chiede il tipo di regole da applicare alla smart cell  */
    HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException;

    void loadAsSmartBoard(ControllerInterface c) throws IOException;
}
