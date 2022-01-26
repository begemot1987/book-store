package com.example.bookstore.controller;

import com.example.bookstore.dto.request.AuthorRequestDto;
import com.example.bookstore.dto.response.AuthorResponseDto;
import com.example.bookstore.dto.response.AuthorWithRateResponseDto;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.mapper.impl.AuthorRequestDtoMapper;
import com.example.bookstore.service.mapper.impl.AuthorResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRequestDtoMapper requestDtoMapper;
    private final AuthorResponseDtoMapper responseDtoMapper;

    public AuthorController(AuthorService authorService,
                            AuthorRequestDtoMapper requestDtoMapper,
                            AuthorResponseDtoMapper responseDtoMapper) {
        this.authorService = authorService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuthorResponseDto add(@RequestBody AuthorRequestDto requestDto) {
        return responseDtoMapper
                .mapToDto(authorService.add(requestDtoMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody AuthorRequestDto requestDto) {
        Author author = requestDtoMapper.mapToModel(requestDto);
        author.setId(id);
        return responseDtoMapper.mapToDto(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @GetMapping("/top")
    public AuthorWithRateResponseDto getMostSuccessful() {
        return authorService.getMostSuccessful();
    }
}
