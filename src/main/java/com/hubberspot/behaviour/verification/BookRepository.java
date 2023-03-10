package com.hubberspot.behaviour.verification;

import java.time.LocalDate;

public interface BookRepository
{
    void save (Book book);
//    Collection<Book> findAll();
//
//    List<Book> findNewBooks(int days);
//
//    Book findByBookIds(String bookId);
Book findByBookIds(String bookId);

    com.hubberspot.argument_matchers.Book findByBookTitleAndPublishedDate(String title, LocalDate localDate);
}