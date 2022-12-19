package com.hubberspot.argument_matcher;

import com.hubberspot.argument_matchers.Book;
import com.hubberspot.argument_matchers.BookRepository;
import com.hubberspot.argument_matchers.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest
{
        @InjectMocks
        private BookService bookService;

        @Mock
        private BookRepository bookRepository;

//    @Test
//    public void testUpdatePrice21()   // no interaction verification
//    {
//        Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
//        Book book2 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
//        when(bookRepository.findByBookIds(any())).thenReturn(book1);
//
//        bookService.updatePrice("1234", 500);
//
//        verify(bookRepository).save(book2);
//    }
//
//    @Test
//    public void testUpdatePrice2()   // no interaction verification
//    {
//        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
//        when(bookRepository.findByBookIds("1234")).thenReturn(book);
//
//        bookService.updatePrice("1234", 500);
//
//        verify(bookRepository).findByBookIds("1234");
//        verifyNoMoreInteractions(bookRepository);
//
//    }
//
//
//    @Test
//    public void test_Given_ABook_When_UpdatedPriceIsCalledWithNewPriceOrUpdatePrice_Then_BookPriceIsUpdated()
//    {
//
//        //Given - Arrange
//        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
//        given(bookRepository.findByBookIds("1234")).willReturn(book);
//
//        //when - Act
//        bookService.updatePrice("1234", 500);
//
//
//        // Then - Assert/Verify
//        then(bookRepository).should().save(book);
//
//    }


        @Test
        public void testInvalidUseOfArgumentMatchers()
        {
            Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
            when(bookRepository.findByBookTitleAndPublishedDate("Mockito in Action", LocalDate.now())).thenReturn(book1);
            Book actualbook = bookService.getBookByTitleAndPublishedDate("Mockito in Action", LocalDate.now());
            assertEquals("Mockito in Action", actualbook.getTitle());
        }

        //Argument Matcher should be provided for all arguments


    @Test
    public void testInvalidUseOfArgumentMatchers1()
    {
        Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        when(bookRepository.findByBookTitleAndPublishedDate(eq("Mockito in Action"), any())).thenReturn(book1);
        Book actualbook = bookService.getBookByTitleAndPublishedDate("Mockito in Action", LocalDate.now());
        assertEquals("Mockito in Action", actualbook.getTitle());
    }


    @Test
    public void testSpecificTypeOfArgumentMatchers1()
    {
        Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        when(bookRepository.findByBookTitleAndPublishedDate(eq("Mockito in Action"), any())).thenReturn(book1);
        Book actualbook = bookService.getBookByTitleAndPublishedDate("Mockito in Action", LocalDate.now());
        assertEquals("Mockito in Action", actualbook.getTitle());
    }

    @Test
    public void testSpecificTypeOfArgumentMatchers2()
    {
        Book book1 = new Book("1234", "Mockito in Action", 600, LocalDate.now());
        when(bookRepository.findByBookTitleAndPublishedDate(anyString(), any())).thenReturn(book1);
        Book actualbook = bookService.getBookByTitleAndPublishedDate("Mockito in Action", LocalDate.now());
        assertEquals("Mockito in Action", actualbook.getTitle());
    }

}

