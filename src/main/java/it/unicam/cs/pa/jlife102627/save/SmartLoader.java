package it.unicam.cs.pa.jlife102627.save;

import com.google.gson.Gson;
import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.Model.SmartBoard;
import it.unicam.cs.pa.jlife102627.Model.SmartCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SmartLoader extends Loader{

    public void load(ControllerInterface c, String path, HashMap<Predicate<Integer>, Consumer<CellInterface>> rules) throws FileNotFoundException {
        File f = new File(path);
        SmartBoard board = new SmartBoard(getDim(f),rules);
        int dim = board.getDim();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(f);
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                board.setCell(gson.fromJson(scanner.nextLine(), SmartCell.class), i, j, rules);
            }
        }
        c.loadBoard(board);
    }
}
