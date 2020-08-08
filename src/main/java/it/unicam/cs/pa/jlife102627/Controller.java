package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.Model.Board;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;

/**
 * Gestisce la tabella e la sua evoluzione a seconda dei comandi ricevuti dall'utente.
 */
public class Controller {

    private BoardInterface board;

    public void newBoard(int dim){
        this.board = new Board(dim);
    }

    public void nextTime(){
        this.board.nextTime();
    }

    public void nextTime(int t){
        for(int i = 0; i < t; i++){
            this.board.nextTime();
        }
    }

    public BoardInterface getBoard() {
        return this.board;
    }
}
