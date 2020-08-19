package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.Model.Board;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.save.LoadInterface;
import it.unicam.cs.pa.jlife102627.save.SaveInterface;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Gestisce la tabella e la sua evoluzione a seconda dei comandi ricevuti dall'utente.
 */
public class Controller implements ControllerInterface{

    private LoadInterface loader;
    private SaveInterface saver;

    private BoardInterface board;

    //todo il primo tiene Key e Value delle regole, se key true allora applico value
    //todo il secondo potrebbe servire per aggiungere o rimuovere
    //todo forse puoi creare un oggetto RULE per fare tutto, pensaci meglio
    private HashMap<Predicate<Integer>, Consumer<CellInterface>> rules;
    private TreeMap<Integer, Predicate<Integer>> rules2;

    public Controller(LoadInterface loader, SaveInterface saver) {
        this.loader = loader;
        this.saver = saver;
    }

    @Override
    public void newBoard(int dim){
        this.board = new Board(dim);
    }

    @Override
    public void nextTime(){
        this.board.nextTime();
    }

    @Override
    public BoardInterface getBoard() {
        return this.board;
    }

    @Override
    public void loadRules() {
        this.rules = loader.getRules();
    }

    @Override
    public void newSmartBoard(int dim) {

    }


}
