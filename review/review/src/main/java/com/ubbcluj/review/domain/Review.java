package com.ubbcluj.review.domain;

public class Review {
    private String title;
    private String author;
    private String textOfReview;

    public String getTextOfReview() {
        return textOfReview;
    }

    public void setTextOfReview(String textOfReview) {
        this.textOfReview = textOfReview;
    }

    public Review(String title, String author, String textOfReview) {
        this.title = title;
        this.author = author;
        this.textOfReview = textOfReview;
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



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", textOfReview=" + textOfReview +
                '}';
    }
}
