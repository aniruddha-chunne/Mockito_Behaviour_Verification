package com.hubberspot.exception_handling;

import com.hubberspot.Test_Double_Stub.BookRequest;
import com.hubberspot.exception_handling.*;

import java.sql.SQLException;
import java.util.List;

public class BookService
{
    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() throws DatabaseReadException {

        List<Book> bookList = null;
        try {
            bookList = bookRepository.findAllBooks();
        } catch (SQLException e) {
            //log the exception
            throw new DatabaseReadException("Unable to read from database due to  - "+ e.getMessage() );
        }

        int totalPrice = 0;

        for(Book book: bookList)
        {
            totalPrice = totalPrice + book.getPrice();
        }

        return totalPrice;

    }

}

