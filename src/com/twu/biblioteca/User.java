package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String libraryId,name,email,password;
    private int phoneNo;

    private List<LibraryItem> borowedItems;


    public User(String libraryId, String name, String email, int phoneNo, String password) {
        this.libraryId = libraryId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        borowedItems = new ArrayList<LibraryItem>();

    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public boolean checkPassword(String password) {
        if(password.equals(this.password)) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }


    public void checkoutItem(LibraryItem book) {
        borowedItems.add(book);
    }

    public List<LibraryItem> getItems() {
        return borowedItems;
    }

    public String listBorrowedItems() {
        String output = "";
        for(LibraryItem item : borowedItems) {
            output += item.toString();
        }
        return output;
    }

    @Override
    public String toString() {
        return getName()  + "\t" + getEmail() + "\t" + getPhoneNo();
    }
}
