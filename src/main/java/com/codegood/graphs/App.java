package com.codegood.graphs;

import com.codegood.graphs.config.ApplcationConfig;
import com.codegood.graphs.controller.Command;
import com.codegood.graphs.view.Menu;

import java.util.List;

public class App {
    public static void main(String[] args) {
        if ("neo4j".equals(args[0])) {
            execteNeo4jApplication();
        }
        if ("garkn".equals(args[0])) {
            executeGarknApplication();
        }
    }

    private static void executeGarknApplication() {
        System.out.println("to be done");
    }

    private static void execteNeo4jApplication() {
        ApplcationConfig applcationConfig = new ApplcationConfig();
        List<Command> commands = applcationConfig.initializeCommands();
        Menu menu = applcationConfig.initializeMenu();

        while (true) {
            menu.show(commands);
            Command choice = menu.getChoice(commands);
            choice.execute();
        }
    }
}
