package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book add(Book book);

    Book update(Book book);

    void delete(Long id);

    List<Book> getByAuthor(String name);

    Book getMostSellingByAuthor(String name);

    Book getMostPublishedByAuthor(String name);

    List<Book> getMostSellingByAuthorPartial(String name);

    List<Book> getMostPublishedByAuthorPartial(String name);

    List<Book> getMostSuccessfulByAuthorPartial(String name);
}
