package com.codegood.graphs.repository;

import org.neo4j.ogm.session.Session;

abstract class GenericRepository<T> {

	protected Session session;
	
	public GenericRepository(Session session){
		this.session = session;
	}
	
	public T read(Long id) {
        return session.load(getEntityType(), id);
    }
	
	public Iterable<T> readAll() {
    	return session.loadAll(getEntityType());
    }

	public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }
    
	public void deleteAll() {
    	session.deleteAll(getEntityType());
    }
    
	public void createOrUpdate(T entity) {
        session.save(entity);
    }

    abstract Class<T> getEntityType();
}