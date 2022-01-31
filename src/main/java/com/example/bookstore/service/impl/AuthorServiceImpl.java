package com.example.bookstore.service.impl;

import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dto.response.AuthorWithRate;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorDao.getById(id);
    }

    @Override
    public Author add(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorDao.save(author);
    }

    @Override
    public void delete(Long id) {
        authorDao.deleteById(id);
    }

    @Override
    public AuthorWithRate getMostSuccessful() {
        return authorDao.getMostSuccessful();
    }
}
