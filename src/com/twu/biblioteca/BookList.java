package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<Book> bookCatalogue= new ArrayList<Book>();
    public void addBook(int id, String title, String author, int year) {
        bookCatalogue.add(new Book(id,year, title, author));
    }

    public String showBooks() {
        String output = "";
        for(Book book:this.bookCatalogue){
            if(book.isAvailable()) {
                output += book.toString() + "\n";
            }
        }
        return output;
    }


    public boolean checkoutBook(int id) {
        for(Book book: this.bookCatalogue){
            if(book.getId() == id) {
               book.checkOut();
               return true;
            }
        }
        return false;
    }

    public boolean returnBook(int id) {
        for(Book book: this.bookCatalogue){
            if(book.getId() == id) {
                book.returnBook();
                return true;
            }
        }
        return false;
    }
}
