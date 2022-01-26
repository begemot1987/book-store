package com.example.bookstore.service.impl;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public Book add(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(Long id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> getByAuthor(String name) {
        return bookDao.findByAuthorName(name);
    }

    @Override
    public Book getMostSellingByAuthor(String name) {
        return bookDao.findFirstByAuthorNameOrderBySoldAmountDesc(name);
    }

    @Override
    public Book getMostPublishedByAuthor(String name) {
        return bookDao.findFirstByAuthorNameOrderByPublishedAmountDesc(name);
    }

    @Override
    public List<Book> getMostSellingByAuthorPartial(String name) {
        return bookDao.getMostSellingByAuthorPartial(name);
    }

    @Override
    public List<Book> getMostPublishedByAuthorPartial(String name) {
        return bookDao.getMostPublishedByAuthorPartial(name);
    }

    @Override
    public List<Book> getMostSuccessfulByAuthorPartial(String name) {
        return bookDao.getMostSuccessfulByAuthorPartial(name);
    }
}
