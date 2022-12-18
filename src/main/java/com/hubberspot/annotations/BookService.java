package com.hubberspot.annotations;

import com.hubberspot.dummyTestDoubles.EmailSerivce;

import java.util.List;

public class BookService
{
    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount (int discountRate, int days)
    {
        List <Book> newbook = bookRepository.findNewBooks(days);

        for (Book book: newbook)
        {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price /100);
            book.setPrice(newPrice);
        }

        return  newbook;
    }

//    public void addBook(Book book)
//    {
//        bookRepository.save(book);
//    }
//
//    public int findNumberOfBooks()
//    {
//        return bookRepository.findAll().size();
//    }
}
