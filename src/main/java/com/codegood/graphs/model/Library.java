package com.codegood.graphs.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
import java.util.Set;

@NodeEntity(label = "Library")
@RequiredArgsConstructor
@Data
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Property(name = "name")
    private final String name;

    @Relationship(type = "LIBRARY_BOOKS")
    private List<Book> books;

    @Relationship(type = "LIBRARY_WORKER")
    private Set<Librarian> librarians;
}
