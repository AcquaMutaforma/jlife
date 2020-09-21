package it.unicam.cs.pa.jlife102627.Model;

import it.unicam.cs.pa.jlife102627.CellType;

import java.util.Random;

/**
 * Rappresenta la tabella della simulazione, ha la responsabilita' di gestire
 * le informazioni legate alla tabella.
 */
public class Board implements BoardInterface{

    protected CellInterface[][] matrix;
    protected final int dim;

    public Board(int d) {
        this.matrix = new CellInterface[d][d];
        this.dim = d;
    }

    @Override
    public CellInterface[][] getBoard() {
        return this.matrix;
    }

    @Override
    public int getNeighbors(int x, int y) {
        int tmp = 0;
        for(int i = x-1; i < x+2; i++){
            for(int j = y-1; j < y+2; j++){
                if(i < 0 || j < 0 || i > getDim()-1 || j > getDim()-1)
                    continue;
                if(this.matrix[i][j].getState())
                    tmp++;
            }
        }
        if(this.matrix[x][y].getState())
            tmp--;
        return tmp;
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
        int[][] next = new int[getDim()][getDim()];
        for(int i = 0; i < this.dim; i++){
            for(int j = 0; j < this.dim; j++){
                next[i][j] = getNeighbors(i,j);
            }
        }
        for(int i = 0; i < this.dim; i++){
            for(int j = 0; j < this.dim; j++){
                this.matrix[i][j].live(next[i][j]);
            }
        }
    }

    @Override
    public CellType getType() {
        return CellType.CLASSIC;
    }

    @Override
    public void setCell(CellInterface c, int x, int y) {
        this.matrix[x][y] = c;
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
