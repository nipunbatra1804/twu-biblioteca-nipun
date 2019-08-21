package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void shouldReceiveSuccessMessageOnCheckoutOfBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);

        Output output = Menu.execute("2 1");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Success"));
    }

    @Test
    public void shouldReceiveFailureMessageOnCheckoutOfBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);

        Output output = Menu.execute("2 3");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Unable"));
    }

    @Test
    public void shouldReturnInvalidCommandFormatForMissingParameters() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);

        Output output = Menu.execute("2");
        assertTrue(output.message().contains("Invalid Input Format"));
    }

    @Test
    public void shouldReturnInvalidCommandFormatForMissingParameterReturnBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);

        Output output = Menu.execute("3");
        assertTrue(output.message().contains("Invalid Input Format"));
    }


    @Test
    public void shouldReceiveSuccessMessageOnReturnOfBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);
        bookList.checkoutBook(1);

        Output output = Menu.execute("3 1");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Success"));
    }

    @Test
    public void shouldReceiveFailureMessageOnReturnOfInvalidBooks() {
        Menu menu = new Menu();
        BookList bookList = new BookList();
        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        Menu.addBookList(bookList);
        bookList.checkoutBook(1);

        Output output = Menu.execute("3 3");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Unable"));
    }

    @Test
    public void shouldTellUserOfInvalidInputOption() {
        Menu menu = new Menu();

        Output output = Menu.execute("-1");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Invalid Menu Option"));
    }


    @Test
    public void shouldDisplayAListOfMovies() {
        Menu menu = new Menu();
        MovieList movieList = new MovieList();
        movieList.addMovie( 110,"The Godfather","Coppola", 1972);
        Menu.addMovieList(movieList);

        Output output = Menu.execute("4");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("The Godfather"));
    }


    @Test
    public void shouldReceiveSuccessMessageOnCheckoutOfMovies() {
        Menu menu = new Menu();
        MovieList movieList = new MovieList();
        movieList.addMovie( 110,"The Godfather","Coppola", 1972);
        Menu.addMovieList(movieList);


        Output output = Menu.execute("5 110");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Success"));
    }

    @Test
    public void shouldReceiveFailureMessageOnCheckoutOfMovies() {
        Menu menu = new Menu();
        MovieList movieList = new MovieList();
        movieList.addMovie( 110,"The Godfather","Coppola", 1972);
        Menu.addMovieList(movieList);



        Output output = Menu.execute("5 3");
        assertEquals(output.isExit(), false);
        assertTrue(output.message().contains("Unable"));
    }






}
