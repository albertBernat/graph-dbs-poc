package com.codegood.graphs.controller;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.exit(1);
    }

    @Override
    public String getLabel() {
        return "Exit application";
    }
}
