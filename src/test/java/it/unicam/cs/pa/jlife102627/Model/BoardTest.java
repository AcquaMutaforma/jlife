package it.unicam.cs.pa.jlife102627.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void getNeighbors() {
        int dim = 2;
        BoardInterface b = new Board(dim);
        b.generateRandomBoard();

        assertTrue(b.getNeighbors(1,1) >= 0);
    }

    @Test
    public void generateRandomBoard() {
        int dim = 2;
        BoardInterface b = new Board(dim);
        b.generateRandomBoard();

        assertEquals(b.getDim(), dim, 0.0);
        assertNotNull(b.getCell(1,1));
    }

    @Test
    public void nextTime() {
        int dim = 2;
        BoardInterface b = new Board(dim);
        b.generateRandomBoard();
        boolean tt = b.getCell(1,1).getState();

        b.nextTime();
        assertTrue(tt != b.getCell(1,1).getState());
    }
}