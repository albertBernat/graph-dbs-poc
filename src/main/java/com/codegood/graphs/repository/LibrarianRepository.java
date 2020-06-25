package com.codegood.graphs.repository;

import com.codegood.graphs.model.Librarian;
import org.neo4j.ogm.session.Session;

public class LibrarianRepository extends GenericRepository<Librarian> {
    public LibrarianRepository(Session session) {
        super(session);
    }

    @Override
    Class<Librarian> getEntityType() {
        return Librarian.class;
    }
}
