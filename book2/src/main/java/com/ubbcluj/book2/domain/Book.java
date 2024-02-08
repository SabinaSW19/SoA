package com.ubbcluj.book2.domain;

public class Book {
    private String title;
    private String author;
    private Integer numberOfProducts;

    public Book(String title, String author, Integer numberOfProducts) {
        this.title = title;
        this.author = author;
        this.numberOfProducts = numberOfProducts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfProducts=" + numberOfProducts +
                '}';
    }
}
