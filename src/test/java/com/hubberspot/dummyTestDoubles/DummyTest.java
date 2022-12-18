package com.hubberspot.dummyTestDoubles;

import com.hubberspot.dummyTestDoubles.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class DummyTest
{

    @Test
    public void testFake()
    {
//        BookRepository bookRepository = (BookRepository) new FakeBookRepository();

        BookRepository bookRepository = new FakeBookRepository();

        EmailSerivce emailSerivce = new DummyEmailService();

        BookService bookService  = new BookService(bookRepository, emailSerivce );

        bookService.addBook(new Book("1234", "Mockito in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("12345", "Junit5 in Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());

    }


    @Test
    public void demoDummywithMockito()
    {
        BookRepository bookRepository = mock(BookRepository.class);
        EmailSerivce emailSerivce = mock(EmailSerivce.class);
        BookService bookService = new BookService(bookRepository, emailSerivce);

        Book book1 = new Book("1234", "Mockito in Action", 250, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 200, LocalDate.now());

        Collection<Book> book = new ArrayList<>();
        book.add(book1);
        book.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(book);
        assertEquals(2, bookService.findNumberOfBooks());
    }

}
