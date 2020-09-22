package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.save.SaveInterface;
import it.unicam.cs.pa.jlife102627.save.Saver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ha la responsabilita' di gestire input e output legati al salvataggio della tabella corrente.
 */
public class SaverView implements SaverViewInterface{

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void save(ControllerInterface c) throws IOException {
        String path = getPath();
        if(path.equals("")) {
            System.out.print("\nPath == \"\"; Board not saved !");
            return;
        }
        SaveInterface saver = new Saver();
        saver.save(c,path);
        System.out.print("\nBoard Saved !!");
    }

    @Override
    public String getPath() throws IOException {
        System.out.print("\nInsert the path to save this board [ENTER = back] > ");
        return input.readLine();
    }
}
