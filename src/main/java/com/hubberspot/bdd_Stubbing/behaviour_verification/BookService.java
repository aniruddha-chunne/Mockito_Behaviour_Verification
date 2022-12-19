package com.hubberspot.bdd_Stubbing.behaviour_verification;

import com.hubberspot.bdd_Stubbing.behaviour_verification.Book;
import com.hubberspot.bdd_Stubbing.behaviour_verification.BookRepository;

public class BookService
{
    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }


    public void updatePrice(String bookId, int updatePrice)
    {

        if(bookId == null)
        {
            return;
        }
        Book book = bookRepository.findByBookIds(bookId);
        book.setPrice(updatePrice);
        bookRepository.save(book);
    }

}

