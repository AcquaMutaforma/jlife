package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.IOException;

/**
 * ha la responsabilita' di gestire input e output legati al caricamento di una tabella.
 */
public interface LoaderViewInterface {

    void load(ControllerInterface c) throws IOException;

    String getPath() throws IOException;
}
