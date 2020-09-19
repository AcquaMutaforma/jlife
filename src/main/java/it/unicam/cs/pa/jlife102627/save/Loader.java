package it.unicam.cs.pa.jlife102627.save;

import com.google.gson.Gson;
import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.Cell;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader implements LoadInterface{

    /*TODO conviene fare un file di config per sapere da subito la dimensione della tabella
       per crearne una nuova e poi modificare il tutto. Potrebbe far comodo chiedere se caricare
       o meno le regole precedenti.

       Config:
       int dim.     String rules        CellType tipo.
     */
    @Override
    public void load(ControllerInterface c, String path) throws FileNotFoundException {
        File f = new File(path);
        if(!f.getAbsoluteFile().exists())
            return;
        Scanner scanner = new Scanner(f);
        Gson gson = new Gson();
        while(scanner.hasNextLine()){
            CellInterface cell = gson.fromJson(scanner.nextLine(), Cell.class);
        }
    }
}
