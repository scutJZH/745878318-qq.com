package com.spring_cloud.management.entity.domain;

public interface IBook {
    void addBookNumber(Integer number) throws Exception;

    void reduceBookNumber(Integer number) throws Exception;
}
