package com.hubberspot.bdd_Stubbing.behaviour.verification;

import com.hubberspot.behaviour.verification.Book;
import com.hubberspot.behaviour.verification.BookRepository;
import com.hubberspot.behaviour.verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;


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
    public void test_Given_ABook_When_UpdatedPriceIsCalledWithNewPriceOrUpdatePrice_Then_BookPriceIsUpdated()
    {

        //Given - Arrange
        Book book = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        given(bookRepository.findByBookIds("1234")).willReturn(book);

        //when - Act
        bookService.updatePrice("1234", 500);


        // Then - Assert/Verify
        then(bookRepository).should().save(book);

    }

}
