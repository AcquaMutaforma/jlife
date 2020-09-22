package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.IOException;

/**
 * ha la responsabilita' di gestire input e output legati al salvataggio della tabella corrente.
 */
public interface SaverViewInterface {

    void save(ControllerInterface c) throws IOException;
    String getPath() throws IOException;

}
