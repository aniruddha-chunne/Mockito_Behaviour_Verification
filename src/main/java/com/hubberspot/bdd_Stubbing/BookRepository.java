package com.hubberspot.bdd_Stubbing;

import java.util.Collection;

public interface BookRepository
{
    void save (Book book);
    Collection<Book> findAll();

    Object findNewBooks(int i);
}