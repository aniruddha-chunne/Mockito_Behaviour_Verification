package com.hubberspot.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository
{
    void save (Book book);

        List<Book> findAllBooks() throws SQLException;


}