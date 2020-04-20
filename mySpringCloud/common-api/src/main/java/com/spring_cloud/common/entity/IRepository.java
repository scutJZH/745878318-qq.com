package com.spring_cloud.common.entity;

public interface IRepository<T extends AggregateRoot> {

    void store(T t);

    T findById(Integer id);
}