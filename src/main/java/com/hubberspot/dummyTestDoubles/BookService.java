package com.hubberspot.dummyTestDoubles;

public class BookService
{
    private BookRepository bookRepository;
    private EmailSerivce emailSerivce;

    public BookService(BookRepository bookRepository, EmailSerivce emailSerivce)
    {
        this.bookRepository = bookRepository;
        this.emailSerivce = emailSerivce;
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }

    public int findNumberOfBooks()
    {
        return bookRepository.findAll().size();
    }
}
