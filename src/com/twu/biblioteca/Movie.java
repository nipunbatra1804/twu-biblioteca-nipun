package com.twu.biblioteca;

public class Movie extends LibraryItem{
    private String director, title;
    public int year;

    public Movie(int id, String title,String director,int year ) {
        super(id);
        this.title = title;
        this.director = director;
        this.year = year;
    }


    @Override
    public String toString(){
        return "#"+ this.getId() + "\t" +this.title + "\t" + this.director+ "\t" +  this.year ;
    }

}
