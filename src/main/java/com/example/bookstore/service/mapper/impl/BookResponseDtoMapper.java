package com.example.bookstore.service.mapper.impl;

import com.example.bookstore.dto.response.BookResponseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class BookResponseDtoMapper implements ResponseDtoMapper<BookResponseDto, Book> {
    @Override
    public BookResponseDto mapToDto(Book model) {
        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(model.getId());
        responseDto.setBookName(model.getBookName());
        responseDto.setAuthor(model.getAuthor());
        responseDto.setPublishedAmount(model.getPublishedAmount());
        responseDto.setSoldAmount(model.getSoldAmount());
        return responseDto;
    }
}
