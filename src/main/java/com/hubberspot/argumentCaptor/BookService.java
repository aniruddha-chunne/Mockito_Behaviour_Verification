package com.hubberspot.argumentCaptor;

import com.hubberspot.argumentCaptor.*;

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

//        if(book.getPrice() == updatePrice)
//        {
//            return;
//        }

        book.setPrice(updatePrice);
        bookRepository.save(book);
    }

//    public List<Book> getNewBooksWithAppliedDiscount (int discountRate, int days)
//    {
//        List <Book> newbook = bookRepository.findNewBooks(days);
//
//        for (Book book: newbook)
//        {
//            int price = book.getPrice();
//            int newPrice = price - (discountRate * price /100);
//            book.setPrice(newPrice);
//        }
//
//        return  newbook;
//    }

//    public void addBook(Book book)
//    {
//        bookRepository.save(book);
//    }
//
//    public int findNumberOfBooks()
//    {
//        return bookRepository.findAll().size();
//    }

//    public int calculateTotalCost(List <String> bookIds)
//    {
//        int total = 0;
//        for(String bookId: bookIds)
//        {
//
//            Book book = bookRepository.findByBookIds(bookId);
//            total = total + book.getPrice();
//        }
//        return total;
//    }
//

//    public void addBook(Book book)
//    {
//
//        if(book.getPrice()<=500)
//        {
//            System.out.println("we are in book service");
//
//            return;
//        }
//
//
//        System.out.println("we are out of if loop");
//        bookRepository.save(book);
//    }

//    public void addBook(BookRequest bookRequest)
//    {
//
//        if(bookRequest.getPrice()<=500)
//        {
//            return;
//        }
//
//        Book book1 = new Book();
//        book1.setTitle(bookRequest.getTitle());
//        book1.setPrice(bookRequest.getPrice());
//        book1.setPublishedDate(bookRequest.getPublishedDate());
//        bookRepository.save(book1);
//    }

    public void addBook(BookRequest bookRequest)
    {

        if(bookRequest.getPrice()<=500)
        {
            return;
        }

        Book book1 = new Book();
        book1.setTitle(bookRequest.getTitle());
        book1.setPrice(bookRequest.getPrice());
        book1.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book1);

    }

}

