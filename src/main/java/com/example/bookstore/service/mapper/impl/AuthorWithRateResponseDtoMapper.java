package com.example.bookstore.service.mapper.impl;

import com.example.bookstore.dto.response.AuthorDaoResponseDto;
import com.example.bookstore.dto.response.AuthorWithRateResponseDto;
import com.example.bookstore.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorWithRateResponseDtoMapper implements
        ResponseDtoMapper<AuthorWithRateResponseDto, AuthorDaoResponseDto> {
    @Override
    public AuthorWithRateResponseDto mapToDto(AuthorDaoResponseDto model) {
        AuthorWithRateResponseDto responseDto = new AuthorWithRateResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setBirthDate(model.getBirthDate());
        responseDto.setPhone(model.getPhone());
        responseDto.setEmail(model.getEmail());
        responseDto.setRate(model.getRate());
        return responseDto;
    }
}
