package com.example.bookstore.dto.request;

public class BookRequestDto {
    private String bookName;
    private Long authorId;
    private int publishedAmount;
    private int soldAmount;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
