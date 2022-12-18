package com.hubberspot.annotations.support;

import com.hubberspot.annotations.Book;
import com.hubberspot.annotations.BookRepository;
import com.hubberspot.annotations.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class AnnotationTest
{

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepositoryspy;

@Test
public void demoCreateMockUsingAnnotations ()
    {
//        BookRepository bookRepositoryspy =  bookRepository;
//        BookService bookService = new BookService(bookRepositoryspy);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();

        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(bookRepositoryspy.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());


    }
}
