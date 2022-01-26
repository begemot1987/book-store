package com.example.bookstore.service.mapper.impl;

import com.example.bookstore.dto.request.AuthorRequestDto;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.mapper.RequestDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorRequestDtoMapper implements RequestDtoMapper<AuthorRequestDto, Author> {
    @Override
    public Author mapToModel(AuthorRequestDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirthDate(dto.getBirthDate());
        author.setPhone(dto.getPhone());
        author.setEmail(dto.getEmail());
        return author;
    }
}
