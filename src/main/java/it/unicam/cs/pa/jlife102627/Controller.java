package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.Model.Board;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.Model.SmartBoard;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Gestisce la tabella e la sua evoluzione eseguendo i comandi ricevuti dall'utente.
 */
public class Controller implements ControllerInterface{

    /* TODO: forse il save e load vanno gestiti dalla view.
        Comunque non devono essere inizializzti
        prima di essere utilizzati, infatti il costruttore di controller
        va cambiato, vedi i commenti lì.
    */
    private BoardInterface board;

    @Override
    public void newBoard(int dim){
        this.board = new Board(dim);
        this.board.generateRandomBoard();
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
    public void newSmartBoard(int dim, HashMap<Predicate<Integer>, Consumer<CellInterface>> r) {
        this.board = new SmartBoard(dim,r);
        this.board.generateRandomBoard();
    }

}