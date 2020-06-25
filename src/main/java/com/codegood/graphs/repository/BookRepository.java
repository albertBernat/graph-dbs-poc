package com.codegood.graphs.repository;

import com.codegood.graphs.model.Author;
import com.codegood.graphs.model.Book;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;


public class BookRepository extends GenericRepository<Book>{

    public BookRepository(Session session) {
        super(session);
    }

    @Override
    Class<Book> getEntityType() {
        return Book.class;
    }

    public Iterable<Book> getAllByAuthor(Author author){
        Filter bookAuthorsFilter = new Filter("BOOK_AUTHORS", ComparisonOperator.EQUALS, author);
        return session.loadAll(getEntityType(), bookAuthorsFilter);
    }
}
