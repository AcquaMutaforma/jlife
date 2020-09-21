package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface ViewInterface {

    void printBoard();
    String getCommand() throws IOException;
    void printCommands(Set<String> set);

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
     */
    void askLoad() throws IOException;

    /**
     * Dopo aver richiesto il percorso all'utente, carica una sessione precedente
     * attraverso LoadInterface
     */
    void load() throws IOException;
    void save() throws IOException;

    void getBoardType() throws IOException;
    HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException;

    void unknown();

    /* Comandi per il controller */
    void nextTime();
    void newBoard() throws IOException;
    void newSmartBoard() throws IOException;

    void printHelp();
}
