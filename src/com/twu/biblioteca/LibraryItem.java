package com.twu.biblioteca;

public class LibraryItem {
    protected int id;
    protected boolean checkedOut = false;

    public LibraryItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable(){
        return !this.checkedOut;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnItem() {
        this.checkedOut = false;
    }
}
