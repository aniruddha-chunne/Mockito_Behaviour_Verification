package com.hubberspot.bdd_Stubbing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.hubberspot.bdd_Stubbing.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Stub_Test
{
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testStubbingInTraditionalMockitoStyle()
    {

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit in Action", 400, LocalDate.now());


        List<Book> newBook =  new ArrayList<>();
        newBook.add(book1);
        newBook.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBook);

        List<Book> newBookwithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBookwithAppliedDiscount.size());
        assertEquals(450, newBookwithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBookwithAppliedDiscount.get(1).getPrice());

    }


    @Test
    @DisplayName("given-New Books, when =get new books with applied Discount is called _ then new books with applied disocount is returned")
    public void test_Given_NewBooks_When_getNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned()
    {

        //Arrange - given
        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("12345", "Junit in Action", 400, LocalDate.now());

        List<Book> newBook =  new ArrayList<>();
        newBook.add(book1);
        newBook.add(book2);

        given(bookRepository.findNewBooks(7)).willReturn(newBook);

        //Act - when

        List<Book> newBookwithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10, 7);


        //Assert - then

//        assertEquals(2, newBookwithAppliedDiscount.size());
//        assertEquals(450, newBookwithAppliedDiscount.get(0).getPrice());
//        assertEquals(360, newBookwithAppliedDiscount.get(1).getPrice());

//        AssertJ = BDD Assertion .. substitute to assertEquals()

            then(newBookwithAppliedDiscount).isNotNull();
        then(newBookwithAppliedDiscount.size()).isEqualTo(2);
        then(newBookwithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
    }




}
