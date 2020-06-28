package com.codegood.graphs.controller;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.model.Book;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.repository.BookRepository;
import com.codegood.graphs.view.View;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBookCommand implements Command {

    private final View view;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void execute() {
        String name = view.readString("Insert name of the book");
        Iterable<Author> authors = authorRepository.readAll();
        view.displayIterable("All authors", authors);
        Long authorId = view.readLong("Choose author");
        Author author = authorRepository.read(authorId);
        Book newBook = Book.builder().name(name).build();
        newBook.addAuthor(author);
        bookRepository.createOrUpdate(newBook);
    }

    @Override
    public String getLabel() {
        return "Create book";
    }
}
