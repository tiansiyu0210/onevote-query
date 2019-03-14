package com.onevote.query.consumer;

public interface Consumer<T> {

    void consume(T t);
}
