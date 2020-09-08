package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.rules.RulesManager;
import it.unicam.cs.pa.jlife102627.rules.RulesManagerInterface;
import it.unicam.cs.pa.jlife102627.view.ViewCli;
import it.unicam.cs.pa.jlife102627.view.ViewInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;

public class App {

    private ControllerInterface controller;
    private final ViewInterface view;

    private HashMap<String, Consumer<ControllerInterface>> commands;

    public App() {
        RulesManagerInterface rulesm = new RulesManager();
        this.controller = new Controller();
        this.view = new ViewCli(this.controller, rulesm);
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.generateCommands();
        app.start();
    }

    public void start() throws IOException {
        this.view.printHello();
        askForLoad();
        generateCommands();
        while (true) {
            String command = this.view.getCommand();
            if(command.equals("exit")) {
                break;
            }
            //TODO probabilmente è meglio dare i comandi alla view che li manda al controller :c
            Consumer<ControllerInterface> action = this.commands.get(command);
            if(action == null){
                this.view.unknown();
                continue;
            }
            action.accept(this.controller);
        }
        this.view.printGoodbye();
    }

    private void askForLoad() throws IOException {
        if(this.view.askLoad())
            this.controller = this.view.load();
    }

    private void generateCommands(){
        //TODO modificare i comandi per view invece che per controller
        this.commands = new HashMap<>();
        this.commands.put("", ControllerInterface::nextTime);
        this.commands.put("next", ControllerInterface::nextTime);
        this.commands.put("new", x -> {
            try {
                x.newBoard(this.view.getBoardParameters());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        this.commands.put("newsmart", x -> {
            try {
                x.newSmartBoard(this.view.getBoardParameters(),
                        this.view.getRules());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
