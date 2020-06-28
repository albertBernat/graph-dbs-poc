package com.codegood.graphs.controller;

import com.codegood.graphs.model.Reader;
import com.codegood.graphs.repository.ReaderRepository;
import com.codegood.graphs.view.View;

public class CreateReaderCommand implements Command{

    private final View view;
    private final ReaderRepository readerRepository;

    public CreateReaderCommand(View view, ReaderRepository readerRepository) {
        this.view = view;
        this.readerRepository = readerRepository;
    }

    @Override
    public void execute() {
        view.display("Insert readers first name");
        String name = view.readString("Name");
        Reader reader = Reader.builder().name(name).build();
        readerRepository.createOrUpdate(reader);
    }

    @Override
    public String getLabel() {
        return "Create reader";
    }
}
