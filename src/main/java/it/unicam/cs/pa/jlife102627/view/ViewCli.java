package it.unicam.cs.pa.jlife102627.view;

import it.unicam.cs.pa.jlife102627.Controller;
import it.unicam.cs.pa.jlife102627.Model.BoardInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewCli implements ViewInterface{

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printBoard(BoardInterface board) {
        System.out.println("\n");
        for(int i = 0; i < board.getDim(); i++){
            for(int j = 0; j < board.getDim(); i++){
                if(board.getCell(i,j).getState())
                    System.out.print("[x]");
                else
                    System.out.print("[ ]");
            }
        }
    }

    @Override
    public void printHello() {
        System.out.print("     __.__  .__  _____       \n" +
                "    |__|  | |__|/ ____\\____  \n" +
                "    |  |  | |  \\   __\\/ __ \\ \n" +
                "    |  |  |_|  ||  | \\  ___/ \n" +
                "/\\__|  |____/__||__|  \\___  >\n" +
                "\\______|                  \\/\n");
    }

    @Override
    public int getGameParameters() throws IOException {
        System.out.print("\nInsert the dimension of the board >");
        return Integer.parseInt(input.readLine());
    }

    @Override
    public String getCommand() throws IOException {
        System.out.print("\ncommand >");
        return input.readLine();
    }

    @Override
    public boolean askLoad() {
        return false;
    }

    @Override
    public Controller load() {
        return null;
    }

    @Override
    public void printGoodbye() {
        System.out.println("\nBye Sir !!\n\n");
    }
}
