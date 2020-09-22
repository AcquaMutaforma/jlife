package it.unicam.cs.pa.jlife102627.save;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.IOException;
/**
 * ha la responsabilita' di definire i metodi per il salvataggio delle tabelle.
 */
public interface SaveInterface {

    void save(ControllerInterface c, String path) throws IOException;

}
