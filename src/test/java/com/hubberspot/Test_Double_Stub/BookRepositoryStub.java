package com.hubberspot.Test_Double_Stub;

import com.hubberspot.behaviour.verification.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookRepositoryStub implements BookRepository
{
    @Override
    public void save(Book book) {

    }

    @Override
    public Collection<Book> findAll()
    {
        return null;
    }

    @Override
    public List<Book> findNewBooks(int days) {

        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);
        return newBooks;

    }

    @Override
    public Book findByBookIds(String bookId) {
        return null;
    }
}
