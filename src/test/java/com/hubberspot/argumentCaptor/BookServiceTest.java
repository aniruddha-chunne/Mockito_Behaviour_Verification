 package com.hubberspot.argumentCaptor;

import com.hubberspot.argumentCaptor.*;
import com.hubberspot.exception_handling.DatabaseReadException;
import com.hubberspot.exception_handling.DatabaseWriteException;
import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

 @ExtendWith(MockitoExtension.class)
public class BookServiceTest
{
        @InjectMocks
        private BookService bookService;

        @Mock
        private BookRepository bookRepository;

        @Test
        public void testSaveBook()
        {
            BookRequest bookRequest =new BookRequest("Mockito in Action", 500, LocalDate.now());
            ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
            bookService.addBook(bookRequest);
            verify(bookRepository).save(bookArgumentCaptor.capture());
            Book book = bookArgumentCaptor.getValue();
            assertEquals( "Mockito in Action", book.getTitle());
        }



}
