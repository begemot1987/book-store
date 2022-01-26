package com.example.bookstore.dto.response;

import com.example.bookstore.model.Author;

public class BookResponseDto {
    private Long id;
    private String bookName;
    private Author author;
    private int publishedAmount;
    private int soldAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishedAmount() {
        return publishedAmount;
    }

    public void setPublishedAmount(int publishedAmount) {
        this.publishedAmount = publishedAmount;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }
}
