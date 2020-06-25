package com.codegood.graphs.controller;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.model.Book;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.repository.BookRepository;
import com.codegood.graphs.view.View;

import java.util.List;

public class ReadAllAuthorBooksCommand implements Command {

    private final View view;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public ReadAllAuthorBooksCommand(View view, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.view = view;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void execute() {
        view.display("Choose author");
        List<Author> authors = (List<Author>) authorRepository.readAll();
        view.displayIterable("Authors", authors);
        Long authorId = view.readLong("Choose author id");
        Author foundAuthor = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst().orElseThrow(IllegalAccessError::new);
        Iterable<Book> allByAuthor = bookRepository.getAllByAuthor(foundAuthor);
        view.displayIterable("All books written by: " + foundAuthor.getName(), allByAuthor);
    }

    @Override
    public String getLabel() {
        return "Read all author books";
    }
}
