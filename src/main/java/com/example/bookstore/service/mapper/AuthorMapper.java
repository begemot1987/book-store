package com.example.bookstore.service.mapper;

import com.example.bookstore.dto.request.AuthorRequestDto;
import com.example.bookstore.dto.response.AuthorResponseDto;
import com.example.bookstore.dto.response.AuthorWithRate;
import com.example.bookstore.dto.response.AuthorWithRateResponseDto;
import com.example.bookstore.model.Author;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponseDto authorToResponseDto(Author author);

    Author requestDtoToAuthor(AuthorRequestDto authorRequestDto);

    AuthorWithRateResponseDto authorWithRateToResponseDto(AuthorWithRate authorWithRate);
}
