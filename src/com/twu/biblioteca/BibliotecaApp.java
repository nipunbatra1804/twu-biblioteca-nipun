package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private Scanner input = new Scanner(System.in);
    private BookList bookList = new BookList();
    private MovieList movieList = new MovieList();

    public String startApp() {

        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        bookList.addBook( 2,"The Great Gatsby", "F. Scott Fitzgerald", 1925);
        bookList.addBook( 3,"Lolita", "Vladimir Nabokov", 1955);
        Menu.addBookList(bookList);

        movieList.addMovie(110,"The Godfather","Coppola", 1972);

        Menu.addMovieList(movieList);

        return ("Welcome to Biblioteca, Your one-stop-shop for great Book titles in Bangalore");
    }

    private  String getInput() {
        return this.input.nextLine();
    }

    public void runApp() {
        boolean exitApp = true;
        do {
            System.out.println(Menu.showMenu());
            String command = getInput();
            Output outputObj = Menu.execute(command);
            exitApp  = outputObj.isExit();
            System.out.println(outputObj.message());
        } while(exitApp != true);
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.startApp());
        app.runApp();
    }
}
