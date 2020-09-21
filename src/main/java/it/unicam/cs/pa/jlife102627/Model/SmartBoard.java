package it.unicam.cs.pa.jlife102627.Model;

import it.unicam.cs.pa.jlife102627.CellType;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SmartBoard extends Board{

    private final HashMap<Predicate<Integer>, Consumer<CellInterface>> rules;

    public SmartBoard(int d, HashMap<Predicate<Integer>, Consumer<CellInterface>> r ) {
        super(d);
        this.rules = r;
    }

    @Override
    public void generateRandomBoard() {
        Random r = new Random();
        for(int i = 0; i < super.matrix.length; i++) {
            for (int j = 0; j < super.matrix.length; j++) {
                super.matrix[i][j] = new SmartCell(r.nextBoolean(),this.rules);
            }
        }
    }

    @Override
    public CellType getType(){
        return CellType.SMART;
    }

    public void setCell(SmartCell c, int x, int y, HashMap<Predicate<Integer>, Consumer<CellInterface>> r) {
        c.setRules(r);
        this.matrix[x][y] = c;
    }
}
