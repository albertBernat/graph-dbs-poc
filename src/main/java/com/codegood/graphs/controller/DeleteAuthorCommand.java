package com.codegood.graphs.controller;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.view.View;

public class DeleteAuthorCommand implements Command {

    private final AuthorRepository authorRepository;
    private final View view;

    public DeleteAuthorCommand(View view, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        Iterable<Author> authors = authorRepository.readAll();
        view.displayIterable("Choose id of author to delete", authors);
        Long idToDelete = view.readLong("ID");
        authorRepository.delete(idToDelete);
    }

    @Override
    public String getLabel() {
        return "Delete author";
    }
}
