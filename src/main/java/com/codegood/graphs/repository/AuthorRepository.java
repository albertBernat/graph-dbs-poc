package com.codegood.graphs.repository;

import com.codegood.graphs.model.Author;
import org.neo4j.ogm.session.Session;

public class AuthorRepository extends GenericRepository<Author> {
    public AuthorRepository(Session session) {
        super(session);
    }

    @Override
    Class<Author> getEntityType() {
        return Author.class;
    }
}
