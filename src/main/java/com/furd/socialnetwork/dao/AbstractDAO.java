package com.furd.socialnetwork.dao;

public interface AbstractDAO<T> {

    T create(T entity);

    T findById(long id);

}
