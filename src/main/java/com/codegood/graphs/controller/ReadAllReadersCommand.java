package com.codegood.graphs.controller;

import com.codegood.graphs.model.Reader;
import com.codegood.graphs.repository.ReaderRepository;
import com.codegood.graphs.view.View;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadAllReadersCommand implements Command{

    private final View view;
    private final ReaderRepository readerRepository;

    @Override
    public void execute() {
        Iterable<Reader> readers = readerRepository.readAll();
        view.displayIterable("All readers", readers);
    }

    @Override
    public String getLabel() {
        return "Get all readers";
    }
}
