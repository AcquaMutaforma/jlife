package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SmartViewInterface{
    //todo: sono presenti questi metodi nell'altra classe, dividileeee !!

    String getBoardType() throws IOException;

    //chiede il tipo di regole da applicare alla smart cell
    HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException;


}
