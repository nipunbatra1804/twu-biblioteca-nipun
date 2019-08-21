package com.twu.biblioteca;

public class BibliotecaApp {

    public String startApp() {
        return ("Welcome to Biblioteca, Your one-stop-shop for great Book titles in Bangalore");
    }

    public static void runApp() {
        Menu.showMenu();
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
