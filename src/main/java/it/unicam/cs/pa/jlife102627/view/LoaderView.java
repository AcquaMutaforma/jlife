package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.save.LoadInterface;
import it.unicam.cs.pa.jlife102627.save.Loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoaderView implements LoaderViewInterface{


    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void load(ControllerInterface c) throws IOException {
        String path = getPath();
        if(path.equals("")) {
            System.out.print("\nPath == \"\"; Command ignored !");
            return;
        }
        LoadInterface loader = new Loader();
        loader.load(c,path);
        System.out.print("\nLoad complete !");
    }

    @Override
    public String getPath() throws IOException {
        System.out.print("\nInsert the path of the board to load [string/ENTER] > ");
        return input.readLine().concat(".txt");
    }
}
