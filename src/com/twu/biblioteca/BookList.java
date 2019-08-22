package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class BookList {

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


    public String checkoutBook(int id, User currentUser) {
        if(currentUser == null){
            return "Unable to checkout book " + id + "\n Not Logged In";
        }

        for(Book book: this.bookCatalogue){
            if(book.getId() == id && book.isAvailable() ==true) {
               book.checkOut();
               currentUser.checkoutItem(book);
               return "Success Book " + id + "checked out" ;
            }
        }
        return "Unable to checkout book " + id;
    }

    public String returnBook(int id, User currentUser) {

        if(currentUser == null){
            return "Unable to Return book " + id + "\n Not Logged In";
        }

        for(Book book: this.bookCatalogue){
            if(book.getId() == id && book.isAvailable() ==false) {
                book.returnItem();
                return "Successfully Returned Book" + id;
            }
        }
        return "Unable to Return book " + id;
    }
}
