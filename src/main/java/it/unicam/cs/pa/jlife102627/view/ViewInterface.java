package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;

public interface ViewInterface {

    void printBoard();

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
    ControllerInterface load();

    void unknown();
    void printGoodbye();
    void printCommands(HashMap<String, Consumer<ControllerInterface>> map);

}
