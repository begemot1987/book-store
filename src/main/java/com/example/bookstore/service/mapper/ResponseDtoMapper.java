package com.example.bookstore.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M model);
}
