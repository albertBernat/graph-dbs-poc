package com.codegood.graphs.controller;

import com.codegood.graphs.model.Book;
import com.codegood.graphs.repository.BookRepository;
import com.codegood.graphs.view.View;

public class ReadAllBooksCommand implements Command {
    private final View view;
    private final BookRepository bookRepository;

    public ReadAllBooksCommand(View view, BookRepository bookRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
    }

    @Override
    public void execute() {
        Iterable<Book> books = bookRepository.readAll();
        view.displayIterable("All books", books);
    }

    @Override
    public String getLabel() {
        return "Read all books";
    }
}
