package it.unicam.cs.pa.jlife102627.Model;

/**
 * ha la responsabilita' di rappresentare una cellula
 */
public class Cell implements CellInterface{

    private boolean state;

    public Cell(boolean state) {  this.state = state;  }

    @Override
    public boolean getState() {   return this.state;   }

    @Override
    public void setState(boolean s) {
        this.state = s;
    }

    @Override
    public void live(int neighbors) {
        if(getState() && ( neighbors == 2 || neighbors == 3))
            return;
        setState(!getState() && neighbors == 3);
    }
}
