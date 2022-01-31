package com.example.bookstore.service;

import com.example.bookstore.dto.response.AuthorWithRate;
import com.example.bookstore.model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getById(Long id);

    Author add(Author author);

    Author update(Author author);

    void delete(Long id);

    AuthorWithRate getMostSuccessful();
}
