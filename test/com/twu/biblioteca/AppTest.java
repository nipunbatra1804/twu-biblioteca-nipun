package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp();
        String output = app.startApp();

        assertEquals("Welcome to Biblioteca, Your one-stop-shop for great Book titles in Bangalore", output);
    }
}
