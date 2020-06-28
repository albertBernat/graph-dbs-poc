package com.codegood.graphs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = "BOOK_AUTHORS")
	private Set<Author> authors;
	
	public void addAuthor(Author author) {
		if (authors == null) {
			this.authors = new HashSet<>();
		}
		authors.add(author);
	}
}