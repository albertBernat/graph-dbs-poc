package com.codegood.graphs.view;

import java.util.Scanner;

public class ConsoleView implements View {

    private Scanner input;

    public ConsoleView() {
        this.input = new Scanner(System.in);
    }

    @Override
    public void printMenu() {

    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayIterable(String message, Iterable<?> elements) {
        display(message);
        elements.forEach(el -> display(el.toString()));
    }

    @Override
    public String readString(String label) {
        display(label + ":");
        return input.next();
    }

    @Override
    public Integer readInt(String label) {
        display(label + ":");
        int value = input.nextInt();
        input.nextLine(); // clear scanner buffer
        return value;
    }

    @Override
    public Long readLong(String label) {
        return readInt(label).longValue();
    }
}
