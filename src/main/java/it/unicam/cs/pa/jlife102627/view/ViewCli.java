package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ViewCli implements ViewInterface{

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    SmartViewInterface smartview;
    ControllerInterface controller;

    public ViewCli(ControllerInterface controller) {
        this.controller = controller;
    }

    @Override
    public void printHello() {
        System.out.print("     __.__  .__  _____       \n" +
                "    |__|  | |__|/ ____\\____  \n" +
                "    |  |  | |  \\   __\\/ __ \\ \n" +
                "    |  |  |_|  ||  | \\  ___/ \n" +
                "/\\__|  |____/__||__|  \\___  >\n" +
                "\\______|                  \\/\n");
        System.out.print("\n\nIf you need help type: help\nTo check the commands type: commands");
    }

    @Override
    public void printHelp() {
        System.out.print("\nTo start a new game, you just have to type 'new' and follow the instructions.\n" +
                "The smart rules are my variant of the classic game of life.\n"+
                "\n\nTo save a board you have to type the path with the new directory's name ( /home/aley/desktop/board_1 )");
    }

    @Override
    public void printBoard() {
        BoardInterface board = this.controller.getBoard();
        if(board == null || board.getCell(0,0) == null)
            return;
        System.out.println("\n");
        for(int i = 0; i < board.getDim(); i++){
            for(int j = 0; j < board.getDim(); j++){
                if(board.getCell(i,j).getState())
                    System.out.print("[x]");
                else
                    System.out.print("[ ]");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    @Override
    public void getBoardType() throws IOException {
        String t;
        do{
            System.out.print("\nSelect the type of the board [default/smart] > ");
            t = input.readLine();
            if(t.equals("default") || t.equals("d") ) {
                newBoard();
            }
            else if(t.equals("smart") || t.equals("s")) {
                newSmartBoard();
            }else
                System.out.print("\nInvalid type !!\n Try again >.<");
        }while(!t.equals("default") && !t.equals("smart") && !t.equals("d") && !t.equals("s"));
    }

    @Override
    public int getBoardParameters() throws IOException {
        System.out.print("\nInsert the dimension of the board > ");
        return Integer.parseInt(input.readLine());
    }

    @Override
    public String getCommand() throws IOException {
        printBoard();
        System.out.print("\ncommand > ");
        return input.readLine();
    }

    @Override
    public boolean askLoad() throws IOException {
        do {
            System.out.print("\nWanna load a board ? [yes/no] > ");
            String load = input.readLine();
            if (load.equals("") || load.equals("yes"))
                return true;
            if (load.toLowerCase().equals("no"))
                return false;
        }while(true);
    }

    @Override
    public void load() throws IOException {
        LoaderViewInterface loader = new LoaderView();
        loader.load(this.controller);
        //TODO aggiungere scelta smart o classic
    }

    @Override
    public void save() throws IOException {
        SaverViewInterface saver = new SaverView();
        saver.save(this.controller);
    }

    @Override
    public void unknown() {
        System.out.print("\nUnknown command");
    }

    @Override
    public void printGoodbye() {
        System.out.println("\nBye Sir !!\n\n");
    }

    @Override
    public void printCommands(Set<String> set) {
        TreeSet<String> words = new TreeSet<>(set);
        String[] wordsArray = words.toArray(new String[] {});
        System.out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    @Override
    public void nextTime() {
        this.controller.nextTime();
    }

    @Override
    public void newBoard() throws IOException {
        this.controller.newBoard(getBoardParameters());
    }

    @Override
    public void newSmartBoard() throws IOException {
        this.controller.newSmartBoard(getBoardParameters(),getRules());
    }

    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException {
        this.smartview = new SmartViewCli(this.input);
        return this.smartview.getRules();
    }
}
