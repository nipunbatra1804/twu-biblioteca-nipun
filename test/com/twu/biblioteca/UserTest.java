package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

public class UserTest {

    UserList users;
    @Before
    public void shouldCreateUsers()  {
        users = new UserList();
        users.addUser(new User("333-4444", "Arjun", "arjun@example.com", 85584422, "passphrase1"));
    }

    @Test
    public void testShouldBeAbleToGetUserWhenPasswordIsCorrect() {
        User currentUser = users.getUser("333-4444","passphrase1" );
        assertEquals(currentUser.getLibraryId(),"333-4444");
        assertEquals(currentUser.getEmail(),"arjun@example.com");
        assertEquals(currentUser.getName(),"Arjun");
        assertEquals(currentUser.getPhoneNo(),85584422);
    }

    @Test
    public void testShouldNotBeAbleToGetUserWhenPasswordIsIncorrect() {
        User currentUser = users.getUser("333-4444","INVALID PASSPHRASE" );
        assertNull(currentUser);
    }

    @Test
    public void testLoggedInUserShouldBeAbleToCheckoutBooks() {
        User currentUser = users.getUser("333-4444","passphrase1" );
        Book book = new Book(1,1922,"Ulysses" ,"James Joyce");
        currentUser.checkoutItem(book);
    }

    @Test
    public void testLoggedInUserShouldBeAbleToViewCheckedoutBooks() {
        User currentUser = users.getUser("333-4444","passphrase1" );
        Book book = new Book(1221,1922,"Ulysses" ,"James Joyce");
        currentUser.checkoutItem(book);
        List<LibraryItem> items =  currentUser.getItems();

        assertEquals(items.get(0).id,1221 );

    }


}
