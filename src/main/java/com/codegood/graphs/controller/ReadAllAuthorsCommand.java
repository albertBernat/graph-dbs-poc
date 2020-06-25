package com.codegood.graphs.controller;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.view.View;

public class ReadAllAuthorsCommand implements Command {

    private final View view;
    private final AuthorRepository authorRepository;

    public ReadAllAuthorsCommand(View view, AuthorRepository authorRepository) {
        this.view = view;
        this.authorRepository = authorRepository;
    }

    @Override
    public void execute() {
        Iterable<Author> authors = authorRepository.readAll();
        view.displayIterable("All authors", authors);
    }

    @Override
    public String getLabel() {
        return "Read all authors";
    }
}
