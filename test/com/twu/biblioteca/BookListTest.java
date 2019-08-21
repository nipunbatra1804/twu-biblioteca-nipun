package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;



public class BookListTest {


    BookList bookList = new BookList();
    @Test
    public void testAddBooks(){

    }

    @Before
    public void addBooksForTest(){

        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        bookList.addBook( 2,"The Great Gatsby", "F. Scott Fitzgerald", 1925);
        bookList.addBook( 3,"Lolita", "Vladimir Nabokov", 1955);
    }


    @Test
    public void testBookList(){

        final String bookListString = bookList.showBooks();


        assertTrue(bookListString.contains("Ulysses"));
        assertTrue(bookListString.contains("The Great Gatsby"));
    }


    @Test
    public void testCheckoutBooks () {

        bookList.checkoutBook(1);
        String bookListString = bookList.showBooks();
        assertFalse(bookListString.contains("Ulysses"));
    }

    

    @Test
    public void testReturnBooks () {
        bookList.checkoutBook(1);
        String bookListString = bookList.showBooks();
        assertFalse(bookListString.contains("Ulysses"));

        bookList.returnBook(1);
        bookListString = bookList.showBooks();
        assertTrue(bookListString.contains("Ulysses"));

    }


}
