package com.codegood.graphs.view;

public interface View {
    void printMenu();
    void display(String message);
    void displayIterable(String message, Iterable<?> elements);
    String readString(String label);
    Integer readInt(String label);
    Long readLong(String label);
}
