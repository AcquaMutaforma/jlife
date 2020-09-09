package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Model.CellInterface;
import it.unicam.cs.pa.jlife102627.rules.RulesManager;
import it.unicam.cs.pa.jlife102627.rules.RulesManagerInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SmartViewCli implements SmartViewInterface{

    BufferedReader input;
    RulesManagerInterface rulesm;

    public SmartViewCli(BufferedReader in) {
        this.input = in;
        this.rulesm = new RulesManager();
    }

    @Override
    public String getBoardType() throws IOException {
        String t;
        do{
            System.out.print("\nSelect the type of the board [default/smart] > ");
            t = input.readLine();
            if(t.equals("default") || t.equals("smart") || t.equals("d") || t.equals("s"))
                return t;
            System.out.print("\nInvalid type !!\n Try again >.<");
        }while(true);
    }

    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException {
        System.out.print("\nChose the life rules of Smart Cells:");
        for(String s : this.rulesm.getAvailableRules()){
            System.out.print("\n- "+s);
        }
        System.out.print("\nRule > ");
        return this.rulesm.getRules(input.readLine());
    }
}
