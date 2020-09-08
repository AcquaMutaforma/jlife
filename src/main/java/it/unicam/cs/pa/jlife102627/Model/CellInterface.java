package it.unicam.cs.pa.jlife102627.Model;

/**
 * Ha la responsabilita' di descrivere le funzioni di una cellula base
 */
public interface CellInterface {

    boolean getState();
    void setState(boolean s);

    void live(int neighbors);
}
