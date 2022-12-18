package com.hubberspot.behaviour.verification;

import java.util.Collection;
import java.util.List;

public interface BookRepository
{
    void save (Book book);
//    Collection<Book> findAll();
//
//    List<Book> findNewBooks(int days);
//
//    Book findByBookIds(String bookId);
Book findByBookIds(String bookId);

}