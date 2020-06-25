package com.codegood.graphs.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Librarian")
public class Librarian {

    @Id
    @GeneratedValue
    private long id;

    @Property(name = "name")
    private String name;

    @Property(name = "familyName")
    private String familyName;

}
