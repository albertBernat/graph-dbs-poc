package com.codegood.graphs.controller;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.view.View;

public class CreateAuthorCommand implements Command {

    private final AuthorRepository authorRepository;
    private final View view;

    public CreateAuthorCommand(View view, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        String authorName = view.readString("Write author Name");
        Author author = new Author(authorName);
        authorRepository.createOrUpdate(author);
    }

    @Override
    public String getLabel() {
        return "Create author";
    }
}
