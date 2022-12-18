package com.hubberspot.dummyTestDoubles;

import java.util.Collection;

public interface BookRepository
{
    void save (Book book);
    Collection<Book> findAll();
    void lone();
}