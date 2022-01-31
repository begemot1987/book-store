package com.example.bookstore.service.mapper;

import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dto.request.BookRequestDto;
import com.example.bookstore.dto.response.BookResponseDto;
import com.example.bookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class BookMapper {
    @Autowired
    protected AuthorDao authorDao;

    public abstract BookResponseDto bookToResponseDto(Book book);

    @Mapping(target = "author",
            expression = "java(authorDao.findById(bookRequestDto.getAuthorId()).get())")
    public abstract Book requestDtoToBook(BookRequestDto bookRequestDto);
}
