package com.hubberspot.Test_Double_Stub;

import com.hubberspot.behaviour.verification.Book;

import java.util.Collection;
import java.util.List;

public interface BookRepository
{
    void save (Book book);
    Collection<Book> findAll();

    List<Book> findNewBooks(int days);

    Book findByBookIds(String bookId);
}