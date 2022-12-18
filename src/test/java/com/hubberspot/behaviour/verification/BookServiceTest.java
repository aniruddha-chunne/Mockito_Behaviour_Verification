package com.hubberspot.behaviour.verification;

import com.hubberspot.behaviour.verification.BookRepository;
import com.hubberspot.behaviour.verification.BookRequest;
import com.hubberspot.behaviour.verification.BookService;
import com.hubberspot.behaviour.verification.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest
{
        @InjectMocks
        private BookService bookService;

        @Mock
        private BookRepository bookRepository;

        @Test
     public void testAddBook()
     {
         Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
         bookService.addBook(book);

         verify(bookRepository).save(book);

     }



//    @Test
//    public void testSaveBookWithBookRequest()
//    {
//
//        BookRequest bookRequest = new BookRequest("Mockito in Action", 600, LocalDate.now());
//        Book book1 = new Book(null, "Mockito in Action", 500, LocalDate.now());
//
//        bookService.addBook(bookRequest);
//
//        verify(bookRepository, Mockito.times(0)).save(book1);
//
//
//    }
//    @Test
//    public void testSaveBookWithBookRequest1()
//    {
//
//        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());
//        Book book1 = new Book(null, "Mockito in Action", 600, LocalDate.now());
//        bookService.addBook(bookRequest);
//        verify(bookRepository, Mockito.times(1)).save(book1);
//    }
//
//    @Test
//    public void testSaveBookWithBookRequest2()  // never method
//    {
//
//        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());
//        Book book1 = new Book(null, "Mockito in Action", 600, LocalDate.now());
//        bookService.addBook(bookRequest);
//        verify(bookRepository, never()).save(book1);
//    }


    @Test
        public void testUpdatePrice()   // no interaction verification
        {
            bookService.updatePrice(null, 600);
            verifyNoInteractions(bookRepository);
        }

    @Test
    public void testUpdatePrice2()   // no interaction verification
    {
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        when(bookRepository.findByBookIds("1234")).thenReturn(book);

        bookService.updatePrice("1234", 500);

        verify(bookRepository).findByBookIds("1234");
        verifyNoMoreInteractions(bookRepository);

    }


    @Test
    public void testUpdatePrice3()   // no interaction verification
    {
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        when(bookRepository.findByBookIds("1234")).thenReturn(book);

        bookService.updatePrice("1234", 500);

        InOrder inOrder = Mockito.inOrder(bookRepository);
       inOrder.verify(bookRepository).findByBookIds("1234");
        inOrder.verify(bookRepository).save(book);
        verify(bookRepository,atLeast(1)).save(book);
        verify(bookRepository,atMost(2)).save(book);

//        verifyNoMoreInteractions(bookRepository);

    }



}
