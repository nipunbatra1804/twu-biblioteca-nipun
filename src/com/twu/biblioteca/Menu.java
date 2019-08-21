package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class Menu {
    private List<String> menuOptions;
    public Menu(){
        menuOptions = new ArrayList<String>( Arrays.asList("1. List All Books"));
    }


    public static String showMenu() {
        String menuOptions = "";
        for (String s : this.menuOptions) {
            menuOptions += s + "/n";
        }
        return menuOptions;
    }



}
