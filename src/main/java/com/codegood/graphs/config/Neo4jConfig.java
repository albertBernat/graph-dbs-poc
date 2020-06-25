package com.codegood.graphs.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jConfig {

    private Neo4jConfig() {
    }

    public static Session getClient() {
        Configuration configuration = new Configuration.Builder().uri("bolt://localhost:7687").credentials("neo4j", "neo4jpassword").build();
        SessionFactory sessionFactory = new SessionFactory(configuration, "com.codegood.graphs");

        return sessionFactory.openSession();
    }
}
