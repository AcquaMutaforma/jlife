package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface ViewInterface {

    void printBoard();
    String getCommand() throws IOException;
    void printHello();
    void printGoodbye();

    /**
     * chiede all'utente la dimensione dalla griglia
     * @return int dimensione tabella
     * @throws IOException se l'utente inserisce un valore non valido
     */
    int getBoardParameters() throws IOException;

    /**
     * Chiede all'utente se vuole caricare una sessione precedente
     * @return risposta utente.
     */
    boolean askLoad() throws IOException;

    /**
     * Dopo aver richiesto il percorso all'utente, carica una sessione precedente
     * attraverso LoadInterface
     */
    void load();
    void save();

    String getBoardType() throws IOException;
    HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException;

    void unknown();
    void printCommands(TreeSet<String> set);

    /* Comandi per il controller */
    void nextTime();
    void newBoard() throws IOException;

}
