package com.codegood.graphs.view;

import com.codegood.graphs.controller.Command;

import java.util.List;

public class Menu {
    private static final String SPACER = "----------";
    private static final String SEPARATOR = ". ";

    private View view;

    public Menu(View view) {
        this.view = view;
    }

    public void show(List<Command> commands) {
        System.out.println(SPACER + "MENU" + SPACER);

        for (Command command : commands) {
            String message = commands.indexOf(command) + SEPARATOR + command.getLabel();
            view.display(message);
        }
    }

    public Command getChoice(List<Command> commands) {
        int choice = view.readInt("Select option: ");
        return commands.get(choice);
    }
}
