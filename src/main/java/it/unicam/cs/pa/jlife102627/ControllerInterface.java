package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.Model.BoardInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface ControllerInterface {

    void newBoard(int dim);
    void nextTime();
    BoardInterface getBoard();

    // Not The Classic Game Of Life
    void newSmartBoard(int dim, HashMap<Predicate<Integer>, Consumer<CellInterface>> r);

}
