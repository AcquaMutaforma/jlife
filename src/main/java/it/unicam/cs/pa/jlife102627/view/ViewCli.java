package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;
import it.unicam.cs.pa.jlife102627.Model.CellInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ViewCli implements ViewInterface{

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    SmartViewInterface smartview;
    ControllerInterface controller;

    public ViewCli(ControllerInterface controller) {
        this.controller = controller;
        this.smartview = new SmartViewCli(this.input);
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
    public void printHello() {
        System.out.print("     __.__  .__  _____       \n" +
                "    |__|  | |__|/ ____\\____  \n" +
                "    |  |  | |  \\   __\\/ __ \\ \n" +
                "    |  |  |_|  ||  | \\  ___/ \n" +
                "/\\__|  |____/__||__|  \\___  >\n" +
                "\\______|                  \\/\n");
        System.out.print("\n\nFor help type: help\nFor check the commands type: commands");
    }

    @Override
    public String getBoardType() throws IOException {
        return this.smartview.getBoardType();
    }

    @Override
    public int getBoardParameters() throws IOException {
        System.out.print("\nInsert the dimension of the board > ");
        return Integer.parseInt(input.readLine());
    }

    @Override
    public HashMap<Predicate<Integer>, Consumer<CellInterface>> getRules() throws IOException {
        return this.smartview.getRules();
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
            if (load.equals("yes"))
                return true;
            if (load.equals("") || load.toLowerCase().equals("no"))
                return false;
        }while(true);
    }

    @Override
    public void load(){
        //TODO
    }

    @Override
    public void save() {
        //TODO
    }

    @Override
    public void unknown() {
        //TODO pensare se va bene o creare un errore apposito
        System.out.print("\nUnknown command");
    }

    @Override
    public void printGoodbye() {
        System.out.println("\nBye Sir !!\n\n");
    }

    @Override
    public void printCommands(TreeSet<String> set) {
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
}
