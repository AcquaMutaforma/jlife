package it.unicam.cs.pa.jlife102627;

import it.unicam.cs.pa.jlife102627.view.ViewCli;
import it.unicam.cs.pa.jlife102627.view.ViewInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;

public class App {

    private Controller controller;
    private final ViewInterface view;

    private HashMap<String, Consumer<Controller>> commands;

    public App() {
        this.controller = new Controller();
        this.view = new ViewCli(this.controller);
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.generateCommands();
        app.start();
    }

    public void start() throws IOException {
        this.view.printHello();
        userInteractions();
        generateCommands();
        while (true) {
            String command = this.view.getCommand();
            if(command.equals("exit")) {
                this.view.printGoodbye();
                break;
            }
            Consumer<Controller> action = this.commands.get(command);
            if(action == null){
                this.view.unknown();
                continue;
            }
            action.accept(this.controller);
        }
        this.view.printGoodbye();
    }

    private void userInteractions() throws IOException {
        if(this.view.askLoad())
            this.controller = this.view.load();
        else
            this.controller.newBoard(this.view.getGameParameters());
    }

    private void generateCommands(){
        this.commands = new HashMap<>();
        this.commands.put("", Controller::nextTime);
        this.commands.put("next", Controller::nextTime);
        this.commands.put("new", x -> {
            try {
                x.newBoard(this.view.getGameParameters());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
    }
}
