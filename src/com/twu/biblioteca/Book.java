package com.twu.biblioteca;

public class Book {
    private int id, year;
    private boolean checkedOut = false;

    public String title,author;


    public Book(int id, int year, String title, String author) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable(){
        return !this.checkedOut;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnBook() {
        this.checkedOut = false;
    }

    @Override
    public String toString(){
        return "#"+this.id + "\t" +this.title + "\t" + this.author+ "\t" +  this.year ;
    }


}

