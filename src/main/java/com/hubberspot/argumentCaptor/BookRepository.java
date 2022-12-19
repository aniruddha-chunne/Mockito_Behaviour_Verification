package com.hubberspot.argumentCaptor;

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