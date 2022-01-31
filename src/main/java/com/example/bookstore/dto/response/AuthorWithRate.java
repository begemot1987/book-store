package com.example.bookstore.dto.response;

import java.time.LocalDate;

public interface AuthorWithRate {
    Long getId();

    String getName();

    LocalDate getBirthDate();

    String getPhone();

    String getEmail();

    Double getRate();
}
