package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;

import java.io.IOException;

public interface LoaderViewInterface {

    void load(ControllerInterface c) throws IOException;

    String getPath() throws IOException;
}
