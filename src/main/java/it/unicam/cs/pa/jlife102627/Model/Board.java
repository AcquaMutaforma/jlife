package it.unicam.cs.pa.jlife102627.Model;

import java.util.Random;

/**
 * Rappresenta la tabella della simulazione, ha la responsabilita' di gestire
 * le informazioni legate alla tabella.
 */
public class Board implements BoardInterface{

    protected final CellInterface[][] matrix;
    protected final int dim;

    public Board(int d) {
        this.matrix = new CellInterface[d][d];
        this.dim = d;
        generateRandomBoard();
    }

    @Override
    public CellInterface[][] getBoard() {
        return this.matrix;
    }

    @Override
    public int getNeighbors(int x, int y) {
        int count = 0;
        for(int i = x-1; i < x+1; i++){
            for(int j = y-1; j < y+1; j++){
                if(i < 0 || j < 0 || i > getDim() || j > getDim())
                    continue;
                if(this.matrix[i][j].getState())
                    count++;
            }
        }
        return count;
    }

    @Override
    public void generateRandomBoard() {
        Random r = new Random();
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = new Cell(r.nextBoolean());
            }
        }
    }

    @Override
    public void nextTime() {
        for(int i = 0; i < this.matrix.length; i++){
            for(int j = 0; j < this.matrix.length; j++){
                this.matrix[i][j].live(getNeighbors(i,j));
            }
        }
    }

    @Override
    public int getDim(){
        return this.dim;
    }

    @Override
    public CellInterface getCell(int x, int y) {
        return this.matrix[x][y];
    }

}
