package com.hubberspot.exception_handling;

import com.hubberspot.behaviour.verification.Book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.hubberspot.exception_handling.*;
import com.hubberspot.exception_handling.*;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest
{
        @InjectMocks
        private BookService bookService;

        @Mock
        private BookRepository bookRepository;

    @Test
     public void testTotalPriceOfBooks() throws SQLException, DatabaseReadException {

         when(bookRepository.findAllBooks()).thenThrow(SQLException.class);

         assertThrows(DatabaseReadException.class, ()->bookService.getTotalPriceOfBooks());

     }

@Test
     public void testAddBook() throws SQLException
     {

         Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());
         doThrow(SQLException.class).when(bookRepository).save(book);
         assertThrows(DatabaseWriteException.class, ()->bookService.addBook(book));
     }


    @Test
    public void testTotalPriceOfBooks3() throws SQLException{

//        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        given(bookRepository.findAllBooks()).willThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, ()->bookService.getTotalPriceOfBooks());

    }
}
