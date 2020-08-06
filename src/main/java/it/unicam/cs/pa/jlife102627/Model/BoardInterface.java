package it.unicam.cs.pa.jlife102627.Model;

/**
 * Definisce le responsabilita' di una tabella base
 */
public interface BoardInterface {

    CellInterface[][] getBoard();

    int getNeighbors(int x, int y);
    void generateRandomBoard();

}
