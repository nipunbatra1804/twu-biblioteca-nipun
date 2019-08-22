package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private  List<String> menuOptions = new ArrayList<String>( Arrays.asList("0. To Exit"
            ,"1. List All Books"
            ,"2. Checkout a Book(Enter 2 <Book Id>"
            ,"3. Return a Book(Enter 3 <Book Id>"
            ,"4. List All Movies"
            ,"5. Checkout a Movie(Enter 2 <Movie Id>"
            ,"6. Return a Movie(Enter 2 <Movie Id>"
            ,"7. User Login"
            ,"8. User Logout"
            ,"9. View My Books"));

    private  BookList bookList;
    private  MovieList movieList;
    private User currentUser;
    private UserList usersDB;

    public Menu(){
        usersDB = new UserList();
    }

    void addUser(User user) {
        usersDB.addUser(user);
    }

    public  void addBookList(BookList books){
        bookList = books;
    }

    public  String showMenu() {
        String options = "";
        for (String s : menuOptions) {
            options += s + "\n";
        }
        return options;
    }

    private void userLogin(String libraryId, String password){
        currentUser = usersDB.getUser(libraryId, password);
    }


    public  Output execute(String command) {

        int commandNo = Integer.parseInt(command.split(" ")[0]);
        int commandParam;
        switch (commandNo) {
            case 0: return new Output(true, "Exit Application! Bye Bye");
            case 1: return new Output(false, bookList.showBooks());
            case 2: try {
                commandParam = Integer.parseInt(command.split(" ")[1]);
                return new Output(false, bookList.checkoutBook(commandParam, currentUser));
            } catch (IndexOutOfBoundsException ex) {
                return new Output(false, "Invalid Input Format");
            }
            case 3: try {
                commandParam =  Integer.parseInt(command.split(" ")[1]);
                return new Output(false, bookList.returnBook(commandParam, currentUser));
            } catch (IndexOutOfBoundsException ex) {
                return new Output(false, "Invalid Input Format");
            }
            case 4: return new Output(false, movieList.showMovies());
            case 5: try {
                commandParam = Integer.parseInt(command.split(" ")[1]);
                return new Output(false, movieList.checkoutMovie(commandParam));
            } catch (IndexOutOfBoundsException ex) {
                return new Output(false, "Invalid Input Format");
            }
            case 6: try {
                commandParam =  Integer.parseInt(command.split(" ")[1]);
                return new Output(false, movieList.returnMovie(commandParam));
            } catch (IndexOutOfBoundsException ex) {
                return new Output(false, "Invalid Input Format");
            }
            case 7: try {
                String[] commandParameterArr = command.split(" ");
                userLogin(commandParameterArr[1], commandParameterArr[2]);
                return new Output(false, "");
            } catch (IndexOutOfBoundsException ex) {
                return new Output(false, "Invalid Input Format");
            }
            case 8: currentUser = null;
                return new Output(false, "");
            case 9: try {
                return new Output(false, currentUser.listBorrowedItems());
            } catch (Exception ex) {
                return new Output(false, "Please Log In");
            }
            case 10: try {
                return new Output(false, currentUser.toString());
            } catch (Exception ex) {
                return new Output(false, "Please Log In");
            }

            default: return new Output(false, "Invalid Menu Option");
        }
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public  void addMovieList(MovieList movies) {
        movieList = movies;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
