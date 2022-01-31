package com.example.bookstore.dao;

import com.example.bookstore.dto.response.AuthorWithRate;
import com.example.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    @Query(value = "SELECT t.id, t.author AS name, t.bd AS birthDate, "
            + "t.phone AS phone, t.email AS email, sum(t.sbr) AS rate "
            + "FROM (SELECT "
            + "((SELECT max(b.sold_amount/b.published_amount) "
            + "FROM books b2 "
            + "JOIN authors a3 "
            + "ON b.author_id = a3.id "
            + "WHERE b.id = b2.id) / "
            + "(SELECT count(b.book_name) "
            + "FROM books b "
            + "JOIN authors a2 "
            + "ON b.author_id = a2.id "
            + "WHERE a2.id = a.id)) AS sbr, a.id AS id, a.name AS author, "
            + "a.birth_date AS bd, a.phone AS phone, a.email AS email "
            + "FROM books b "
            + "JOIN authors a "
            + "ON b.author_id = a.id "
            + "GROUP BY b.id, a.id) AS t "
            + "GROUP BY t.id "
            + "ORDER BY rate DESC "
            + "LIMIT 1", nativeQuery = true)
    AuthorWithRate getMostSuccessful();
}
