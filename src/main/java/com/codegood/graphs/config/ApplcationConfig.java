package com.codegood.graphs.config;

import com.codegood.graphs.controller.Command;
import com.codegood.graphs.controller.CreateAuthorCommand;
import com.codegood.graphs.controller.CreateBookCommand;
import com.codegood.graphs.controller.CreateReaderCommand;
import com.codegood.graphs.controller.DeleteAuthorCommand;
import com.codegood.graphs.controller.ExitCommand;
import com.codegood.graphs.controller.ReadAllAuthorBooksCommand;
import com.codegood.graphs.controller.ReadAllAuthorsCommand;
import com.codegood.graphs.controller.ReadAllBooksCommand;
import com.codegood.graphs.controller.ReadAllReadersCommand;
import com.codegood.graphs.repository.AuthorRepository;
import com.codegood.graphs.repository.BookRepository;
import com.codegood.graphs.repository.LibrarianRepository;
import com.codegood.graphs.repository.ReaderRepository;
import com.codegood.graphs.view.ConsoleView;
import com.codegood.graphs.view.Menu;
import com.codegood.graphs.view.View;
import org.neo4j.ogm.session.Session;

import java.util.ArrayList;
import java.util.List;

public class ApplcationConfig {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private ReaderRepository readerRepository;
    private LibrarianRepository librarianRepository;
    private final View view = new ConsoleView();

    public List<Command> initializeCommands() {
        Session client = Neo4jConfig.getClient();
        authorRepository = new AuthorRepository(client);
        bookRepository = new BookRepository(client);
        readerRepository = new ReaderRepository(client);
        librarianRepository = new LibrarianRepository(client);

        List<Command> commands = new ArrayList<>();
        commands.add(new CreateAuthorCommand(view, authorRepository));
        commands.add(new ReadAllAuthorsCommand(view, authorRepository));
        commands.add(new DeleteAuthorCommand(view, authorRepository));
        commands.add(new ReadAllBooksCommand(view, bookRepository));
        commands.add(new CreateBookCommand(view,bookRepository, authorRepository));
        commands.add(new ReadAllAuthorBooksCommand(view, bookRepository, authorRepository));
        commands.add(new CreateReaderCommand(view, readerRepository));
        commands.add(new ReadAllReadersCommand(view, readerRepository));
        commands.add(new ExitCommand());
        return commands;
    }

    public Menu initializeMenu() {
        return new Menu(view);
    }
}
