package com.codegood.graphs.model;

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

@NodeEntity(label = "Book")
@Data
public class Book {
	public Book() {
	}

	public Book(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = "BOOK_AUTHORS")
	private Set<Author> authors = new HashSet<>();
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
}