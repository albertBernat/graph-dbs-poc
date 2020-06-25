package com.codegood.graphs.repository;

import com.codegood.graphs.model.Reader;
import org.neo4j.ogm.session.Session;

public class ReaderRepository extends GenericRepository<Reader>{
    public ReaderRepository(Session session) {
        super(session);
    }

    @Override
    Class<Reader> getEntityType() {
        return Reader.class;
    }
}
