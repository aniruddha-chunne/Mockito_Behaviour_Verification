package com.hubberspot.dummyTestDoubles;

import com.hubberspot.dummyTestDoubles.Book;
import com.hubberspot.dummyTestDoubles.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository
{

    Map<String, com.hubberspot.dummyTestDoubles.Book> bookstore = new HashMap<>();


    @Override
    public void save(Book book) {
        bookstore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookstore.values();
    }

    @Override
    public void lone() {

    }
}
