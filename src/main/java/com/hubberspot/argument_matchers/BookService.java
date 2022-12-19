package com.hubberspot.argument_matchers;

import com.hubberspot.exception_handling.DatabaseReadException;
import com.hubberspot.exception_handling.DatabaseWriteException;
import com.hubberspot.argument_matchers.Book;
import com.hubberspot.argument_matchers.BookRepository;
import com.hubberspot.argument_matchers.BookRequest;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public Book getBookByTitleAndPublishedDate(String Title, LocalDate localDate)
    {
         return bookRepository.findByBookTitleAndPublishedDate(Title, localDate);
    }


    public void addBook(Book book) throws DatabaseWriteException {
        try {
            bookRepository.save(book);
        } catch (SQLException e)
        {
            //log
            throw new DatabaseWriteException ("Unable to write in database due to  - " + e.getMessage());
        }
    }

}

