package com.twu.biblioteca;

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


    public String checkoutBook(int id) {
        for(Book book: this.bookCatalogue){
            if(book.getId() == id && book.isAvailable() ==true) {
               book.checkOut();
               return "Success Book " + id + "checked out" ;
            }
        }
        return "Unable to checkout book " + id;
    }

    public String returnBook(int id) {
        for(Book book: this.bookCatalogue){
            if(book.getId() == id && book.isAvailable() ==false) {
                book.returnBook();
                return "Successfully Returned Book" + id;
            }
        }
        return "Unable to Return book " + id;
    }
}
