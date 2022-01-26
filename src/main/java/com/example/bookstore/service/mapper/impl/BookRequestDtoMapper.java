package com.example.bookstore.service.mapper.impl;

import com.example.bookstore.dto.request.BookRequestDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.mapper.RequestDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class BookRequestDtoMapper implements RequestDtoMapper<BookRequestDto, Book> {
    private final AuthorService authorService;

    public BookRequestDtoMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Book mapToModel(BookRequestDto dto) {
        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setAuthor(authorService.getById(dto.getAuthorId()));
        book.setSoldAmount(dto.getSoldAmount());
        book.setPublishedAmount(dto.getPublishedAmount());
        return book;
    }
}
