package com.twu.biblioteca;

public class Book extends LibraryItem{
    private int year;
    private String title,author;

    public Book(int id, int year, String title, String author) {
        super(id);
        this.year = year;
        this.title = title;
        this.author = author;
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

    @Override
    public String toString(){
        return "#"+ this.getId() + "\t" +this.title + "\t" + this.author+ "\t" +  this.year ;
    }


}

