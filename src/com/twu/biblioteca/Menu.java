package com.twu.biblioteca;

import com.sun.tools.javac.util.Convert;

import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class Menu {
    private static List<String> menuOptions = new ArrayList<String>( Arrays.asList("0. To Exit","1. List All Books"));
    private static BookList bookList;


    public static void addBookList(BookList books){
        bookList = books;
    }

    public static String showMenu() {
        String options = "";
        for (String s : menuOptions) {
            options += s + "\n";
        }
        return options;
    }


    public static Output execute(String command) {

        int commandNo = Integer.parseInt(command);
        switch (commandNo) {
            case 0: return new Output(true, "Exit Application! Bye Bye");
            case 1: return new Output(false, bookList.showBooks());
        }
        return null;
    }
}
