package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private Scanner input = new Scanner(System.in);
    private BookList bookList = new BookList();
    private MovieList movieList = new MovieList();
    private UserList userList = new UserList();
    private Menu menu = new Menu();
    private User currentUser;


    public String startApp() {

        bookList.addBook( 1,"Ulysses","James Joyce", 1922);
        bookList.addBook( 2,"The Great Gatsby", "F. Scott Fitzgerald", 1925);
        bookList.addBook( 3,"Lolita", "Vladimir Nabokov", 1955);
        menu.addBookList(bookList);
        movieList.addMovie(110,"The Godfather","Coppola", 1972);
        menu.addMovieList(movieList);

        return ("Welcome to Biblioteca, Your one-stop-shop for great Book titles in Bangalore");
    }

    private  String getInput() {
        return this.input.nextLine();
    }

    public void runApp() {
        boolean exitApp = true;
        do {
            System.out.println(menu.showMenu());
            String command = getInput();
            Output outputObj = menu.execute(command);
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
