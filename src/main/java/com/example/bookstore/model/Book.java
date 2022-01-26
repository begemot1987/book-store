package com.example.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_name")
    private String bookName;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "published_amount")
    private int publishedAmount;
    @Column(name = "sold_amount")
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

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", bookName='" + bookName + '\''
                + ", author=" + author
                + ", publishedAmount=" + publishedAmount
                + ", soldAmount=" + soldAmount
                + '}';
    }
}
