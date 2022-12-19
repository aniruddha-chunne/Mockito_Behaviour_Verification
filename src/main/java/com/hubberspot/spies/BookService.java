package com.hubberspot.spies;


public class BookService
{

    public Book findBook(String bookId)
    {
            return null;
    }

    public int getAppliedDiscount(Book book, int discountRate) {

        int price = book.getPrice();
        int newPrice = price - (price * discountRate/100);
        return  newPrice;
    }
}
