package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Controller;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;

import java.io.IOException;

public interface ViewInterface {

    void printBoard(BoardInterface board);

    void printHello();
    int getGameParameters() throws IOException;
    String getCommand() throws IOException;

    /**
     * Chiede all'utente se vuole caricare una sessione precedente
     * @return risposta utente.
     */
    boolean askLoad() throws IOException;

    /**
     * Dopo aver richiesto il percorso all'utente, carica una sessione precedente
     * attraverso LoadInterface
     * @return Controller
     */
    Controller load();

    void unknown();
    void printGoodbye();

}
