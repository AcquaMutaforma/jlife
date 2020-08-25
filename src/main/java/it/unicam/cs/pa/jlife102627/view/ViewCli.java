package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.ControllerInterface;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Consumer;

public class ViewCli implements ViewInterface{

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    ControllerInterface controller;

    public ViewCli(ControllerInterface controller) {
        this.controller = controller;
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
    public int getGameParameters() throws IOException {
        /*TODO decidere come farlo funzionare eheh
        System.out.print("\nWhat type of board do you want to create ? [normal/smart] > ");
        String t = input.readLine();
         */
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
            if (load.equals("yes"))
                return true;
            if (load.equals("") || load.toLowerCase().equals("no"))
                return false;
        }while(true);
    }

    @Override
    public ControllerInterface load() {
        return null;
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
    public void printCommands(HashMap<String, Consumer<ControllerInterface>> map) {

    }
}
