package it.unicam.cs.pa.jlife102627.Model;

import java.util.Random;

/**
 * Rappresenta la tabella della simulazione
 */
public class Board implements BoardInterface{

    private final CellInterface[][] matrix;

    public Board(int d) {
        matrix = new Cell[d][d];
        generateRandomBoard();
    }

    @Override
    public CellInterface[][] getBoard() {
        return this.matrix;
    }

    @Override
    public int getNeighbors(int x, int y) {
        return 0;
    }

    @Override
    public void generateRandomBoard() {
        Random r = new Random();
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j< matrix.length; j++)
                matrix[i][j] = new Cell(r.nextBoolean());
    }
}
