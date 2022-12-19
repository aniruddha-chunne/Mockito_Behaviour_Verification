package com.hubberspot.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest
{

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy()
    {
//        BookService bookService = Mockito.spy(BookService.class);
//
//        BookManager bookManager = new BookManager(bookService);

//         We need to mock getBook because it is communicating to database or not

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Mockito.doReturn(book1).when(bookService).findBook("1234");
        int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
        assertEquals(450, actualDiscount);



    }

}
