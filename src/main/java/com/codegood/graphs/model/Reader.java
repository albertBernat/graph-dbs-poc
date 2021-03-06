package com.codegood.graphs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Reader")
@AllArgsConstructor
@Data
@Builder
public class Reader {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    @Relationship(type = "READER_BOOKS")
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        books.add(book);
    }

}