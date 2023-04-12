package com.spb.spb0410.VO;

public class MybookVO {
    private int ID;
    private String isbn;
    private String name;
    private String author;
    
  //getters, setters, constructors and toString

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }


    public String getIsbn() {
        return isbn;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MybookVO [ID=" + ID + ", isbn=" + isbn + ", name=" + name + ", author=" + author + "]";
    }


    
}