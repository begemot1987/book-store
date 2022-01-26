package com.example.bookstore.service.mapper.impl;

import com.example.bookstore.dto.response.AuthorResponseDto;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorResponseDtoMapper implements ResponseDtoMapper<AuthorResponseDto, Author> {
    @Override
    public AuthorResponseDto mapToDto(Author model) {
        AuthorResponseDto responseDto = new AuthorResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setBirthDate(model.getBirthDate());
        responseDto.setPhone(model.getPhone());
        responseDto.setEmail(model.getEmail());
        return responseDto;
    }
}
