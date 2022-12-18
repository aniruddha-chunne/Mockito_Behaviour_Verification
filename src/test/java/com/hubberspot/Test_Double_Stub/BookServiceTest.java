package com.hubberspot.Test_Double_Stub;

import com.hubberspot.behaviour.verification.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        public void testCalculatedTotalCostOFBooks()
        {
            List<String> bookIds = new ArrayList<>();
            bookIds.add("1234");
            bookIds.add("12345");

            Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
            Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

//            when(bookRepository.findByBookIds("1234")).thenReturn(book1);
//            when(bookRepository.findByBookIds("12345")).thenReturn(book2);
            doReturn(book1).when(bookRepository).findByBookIds("1234");
            doReturn(book2).when(bookRepository).findByBookIds("12345");


            int actualcost  = bookService.calculateTotalCost(bookIds);

            assertEquals(900, actualcost);

        }

        @Test
        public void testSaveBook()
        {
            Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
            Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

            doNothing().when(bookRepository).save(book1);
            bookService.addBook(book1);
        }

    @Test
    public void testSaveBookWithBookRequest()
    {
//        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
//        Book book2 = new Book("12345", "Junit5 in Action", 400, LocalDate.now());

//        doNothing().when(bookRepository).save(book1);
//        bookService.addBook(book1);

        BookRequest bookRequest = new BookRequest("Mockito in Action", 500, LocalDate.now());
        Book book1 = new Book(null, "Mockito in Action", 500, LocalDate.now());

//        doNothing().when(bookRepository).save(book1);
        bookService.addBook(bookRequest);




    }






}
