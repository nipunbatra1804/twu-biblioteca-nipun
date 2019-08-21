package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.TestCase.*;


public class MovieListTest {


    MovieList MovieList = new MovieList();

    @Before
    public void addMoviesForTest(){
        MovieList.addMovie( 1,"Ulysses","James Joyce", 1922);
        MovieList.addMovie( 2,"The Great Gatsby", "F. Scott Fitzgerald", 1925);
        MovieList.addMovie( 3,"Lolita", "Vladimir Nabokov", 1955);
    }


    @Test
    public void testMovieList(){

        final String MovieListString = MovieList.showMovies();


        assertTrue(MovieListString.contains("Ulysses"));
        assertTrue(MovieListString.contains("The Great Gatsby"));
    }


    @Test
    public void testCheckoutMovies () {

        String ouputString = MovieList.checkoutMovie(1);
        String MovieListString = MovieList.showMovies();
        assertFalse(MovieListString.contains("Ulysses"));
        assertTrue(ouputString.contains("Success"));
    }

    @Test
    public void shouldNotBeAbleToCheckoutMoviesWithInvalidIDs () {
        String ouputString = MovieList.checkoutMovie(-1);
        assertTrue(ouputString.contains("Unable to checkout"));
    }

    @Test
    public void shouldReturnValidMovies () {
        MovieList.checkoutMovie(1);
        String MovieListString = MovieList.showMovies();
        assertFalse(MovieListString.contains("Ulysses"));

        String ouputString = MovieList.returnMovie(1);
        MovieListString = MovieList.showMovies();
        assertTrue(MovieListString.contains("Ulysses"));

        assertTrue(ouputString.contains("Successfully Returned"));

    }

    @Test
    public void shouldNotReturnValidMovies () {
        MovieList.checkoutMovie(1);
        String MovieListString = MovieList.showMovies();
        assertFalse(MovieListString.contains("Ulysses"));

        String ouputString = MovieList.returnMovie(-1);
        MovieListString = MovieList.showMovies();
        assertFalse(MovieListString.contains("Ulysses"));

        assertTrue(ouputString.contains("Unable to Return"));

    }



}
