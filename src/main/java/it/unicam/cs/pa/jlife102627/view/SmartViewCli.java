package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.rules.RulesManager;
import it.unicam.cs.pa.jlife102627.rules.RulesManagerInterface;
import it.unicam.cs.pa.jlife102627.save.SmartLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Ha la responsabilità di gestire gli input e output legati ai componenti Smart.
 */
public class SmartViewCli implements SmartViewInterface{

    BufferedReader input;
    RulesManagerInterface rulesm;

    public SmartViewCli(BufferedReader in) {
        this.input = in;
        this.rulesm = new RulesManager();
    }

    /**
     * stampa le regole disponibili del rulesManager e ritorna le regole
     * che corrispondono all'input dell'utente
     * @return regole per smarCell
     * @throws IOException .
     */
    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException {
        System.out.print("\nChose the life rules of Smart Cells:");
        for(String s : this.rulesm.getAvailableRules()){
            System.out.print("\n- "+s);
        }
        System.out.print("\nRule > ");
        return this.rulesm.getRules(input.readLine());
    }

    /**
     * inizializza il caricamento di una smartBoard.
     * @param c controller in cui caricare la tabella.
     * @throws IOException errore di digitura dell'utente.
     */
    public void loadAsSmartBoard(ControllerInterface c) throws IOException {
        SmartLoader sloader = new SmartLoader();
        LoaderViewInterface lview = new LoaderView();
        sloader.load(c,lview.getPath().concat("/board.txt"), getRules());
    }

}
