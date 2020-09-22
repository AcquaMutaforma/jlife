package it.unicam.cs.pa.jlife102627.save;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.FileNotFoundException;

/**
 * ha la responsabilita' di definire i metodi per il caricamento
 */
public interface LoadInterface {

    void load(ControllerInterface c, String path) throws FileNotFoundException;

}
