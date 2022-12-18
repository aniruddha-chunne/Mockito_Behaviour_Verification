package com.hubberspot;

import com.hubberspot.Test_Double_Stub.BookRepository;
import com.hubberspot.Test_Double_Stub.BookRepositoryStub;
import com.hubberspot.Test_Double_Stub.BookService;
import org.junit.jupiter.api.Test;
import com.hubberspot.behaviour.verification.Book;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stub_Test
{
    @Test
    public void demoStub()
    {
        BookRepository bookRepository = new BookRepositoryStub();

        BookService bookService1 = new BookService(bookRepository);
        List<Book> newBookwithAppliedDiscount =  bookService1.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBookwithAppliedDiscount.size());
        assertEquals(450, newBookwithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBookwithAppliedDiscount.get(1).getPrice());

    }
}
