package com.hubberspot.mock;

import org.junit.jupiter.api.Test;
import com.hubberspot.mock.Book;
import com.hubberspot.mock.BookRepository;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest
{
    @Test
    public void demoMock()
    {
        BookRepository bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        ((BookRepositoryMock) bookRepositoryMock).verify(book2, 1);
    }

    @Test
    public void demoMockWithMockito()
    {
        BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

//        ((BookRepositoryMock) bookRepositoryMock).verify(book2, 1);

        Mockito.verify(bookRepositoryMock, Mockito.times(1)).save(book2);
//        Mockito.verify(bookRepositoryMock).save(book1);
    }
}
