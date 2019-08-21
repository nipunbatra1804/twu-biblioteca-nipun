package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MenuTest {
    @Test
    public void testMenuOptions() {
        Menu menu = new Menu();

        String output = menu.showMenu();

        assertTrue(output.contains(("1. List All Books")));
    }


    @Test
    public void shouldReturnExitAppWhenOption0isEntered() {
        Menu menu = new Menu();
        Output output = Menu.execute("0");

        assertEquals(output.isExit(), true);
    }

    @Test
    public void shouldDisplayAListOfBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);

        Output output = Menu.execute("1");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Ulysses"));


    }

}
