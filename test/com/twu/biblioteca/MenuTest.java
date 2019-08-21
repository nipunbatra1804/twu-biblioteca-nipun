package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MenuTest {
    @Test
    public void testMenuOptions() {
        Menu menu = new Menu();

        String output = menu.showMenu();

        assertTrue(output.contains(("1. List All Books")));
    }

}
