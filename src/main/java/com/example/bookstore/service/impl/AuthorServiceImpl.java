package com.example.bookstore.service.impl;

import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dto.response.AuthorWithRateResponseDto;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.mapper.impl.AuthorWithRateResponseDtoMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;
    private final AuthorWithRateResponseDtoMapper responseDtoMapper;

    public AuthorServiceImpl(AuthorDao authorDao,
                             AuthorWithRateResponseDtoMapper responseDtoMapper) {
        this.authorDao = authorDao;
        this.responseDtoMapper = responseDtoMapper;
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
    public AuthorWithRateResponseDto getMostSuccessful() {
        return responseDtoMapper.mapToDto(authorDao.getMostSuccessful());
    }
}
