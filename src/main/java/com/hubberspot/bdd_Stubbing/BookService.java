package com.hubberspot.bdd_Stubbing;

import com.hubberspot.bdd_Stubbing.Book;
import com.hubberspot.bdd_Stubbing.BookRepository;

import java.util.List;


public class BookService
{
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }

    public int findNumberOfBooks()
    {
        return bookRepository.findAll().size();
    }

    public List<Book> getNewBooksWithAppliedDiscount (int discountRate, int days)
    {
        List <Book> newbook = (List<Book>) bookRepository.findNewBooks(days);

        for (Book book: newbook)
        {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price /100);
            book.setPrice(newPrice);
        }

        return  newbook;
    }
}
