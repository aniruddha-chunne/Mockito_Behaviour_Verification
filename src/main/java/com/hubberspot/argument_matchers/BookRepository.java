package com.hubberspot.argument_matchers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.hubberspot.argument_matchers.Book;
import com.hubberspot.argument_matchers.BookRequest;


public interface BookRepository
{

        List<Book> findAllBooks() throws SQLException;
        void save(Book book) throws SQLException;


        Book findByBookTitleAndPublishedDate(String title, LocalDate localDate);
}