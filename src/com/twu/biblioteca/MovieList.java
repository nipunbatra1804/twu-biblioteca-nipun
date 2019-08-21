package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class MovieList {

    private List<Movie> MovieCatalogue= new ArrayList<Movie>();
    public void addMovie(int id, String title, String director, int year) {
        MovieCatalogue.add(new Movie(id, title, director, year));
    }

    public String showMovies() {
        String output = "";
        for(Movie Movie:this.MovieCatalogue){
            if(Movie.isAvailable()) {
                output += Movie.toString() + "\n";
            }
        }
        return output;
    }


    public String checkoutMovie(int id) {
        for(Movie Movie: this.MovieCatalogue){
            if(Movie.getId() == id && Movie.isAvailable() ==true) {
                Movie.checkOut();
                return "Success Movie " + id + "checked out" ;
            }
        }
        return "Unable to checkout Movie " + id;
    }

    public String returnMovie(int id) {
        for(Movie Movie: this.MovieCatalogue){
            if(Movie.getId() == id && Movie.isAvailable() ==false) {
                Movie.returnItem();
                return "Successfully Returned Movie" + id;
            }
        }
        return "Unable to Return Movie " + id;
    }
}
