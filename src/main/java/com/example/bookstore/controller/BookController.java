package com.example.bookstore.controller;

import com.example.bookstore.dto.request.BookRequestDto;
import com.example.bookstore.dto.response.BookResponseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.mapper.impl.BookRequestDtoMapper;
import com.example.bookstore.service.mapper.impl.BookResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookResponseDtoMapper responseDtoMapper;
    private final BookRequestDtoMapper requestDtoMapper;

    public BookController(BookService bookService,
                          BookResponseDtoMapper responseDtoMapper,
                          BookRequestDtoMapper requestDtoMapper) {
        this.bookService = bookService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookResponseDto add(@RequestBody BookRequestDto requestDto) {
        return responseDtoMapper
                .mapToDto(bookService.add(requestDtoMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        Book book = requestDtoMapper.mapToModel(requestDto);
        book.setId(id);
        return responseDtoMapper.mapToDto(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/by-author")
    public List<BookResponseDto> getByAuthor(@RequestParam String name) {
        return bookService.getByAuthor(name)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-author/bestseller")
    public BookResponseDto getMostSellingByAuthor(@RequestParam String name) {
        return responseDtoMapper.mapToDto(bookService.getMostSellingByAuthor(name));
    }

    @GetMapping("/by-author/top-published")
    public BookResponseDto getMostPublishedByAuthor(@RequestParam String name) {
        return responseDtoMapper.mapToDto(bookService.getMostPublishedByAuthor(name));
    }

    @GetMapping("/bestsellers/by-author")
    public List<BookResponseDto> getMostSellingByAuthorPartial(@RequestParam String name) {
        return bookService.getMostSellingByAuthorPartial(name)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/top-published/by-author")
    public List<BookResponseDto> getMostPublishedByAuthorPartial(@RequestParam String name) {
        return bookService.getMostPublishedByAuthorPartial(name)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/top/by-author")
    public List<BookResponseDto> getMostSuccessfulByAuthorPartial(@RequestParam String name) {
        return bookService.getMostSuccessfulByAuthorPartial(name)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
