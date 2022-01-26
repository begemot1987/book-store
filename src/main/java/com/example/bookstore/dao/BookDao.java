package com.example.bookstore.dao;

import com.example.bookstore.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> findByAuthorName(String name);

    Book findFirstByAuthorNameOrderBySoldAmountDesc(String name);

    Book findFirstByAuthorNameOrderByPublishedAmountDesc(String name);

    @Query(value = "SELECT b.id, b.book_name, b.author_id, "
            + "b.published_amount, max(b.sold_amount) AS sold_amount "
            + "FROM books b JOIN authors a ON b.author_id = a.id "
            + "WHERE UPPER(a.name) LIKE UPPER(:name) GROUP BY a.id", nativeQuery = true)
    List<Book> getMostSellingByAuthorPartial(String name);

    @Query(value = "SELECT b.id, b.book_name, b.author_id, "
            + "max(b.published_amount) AS published_amount, b.sold_amount "
            + "FROM books b JOIN  authors a ON b.author_id = a.id "
            + "WHERE UPPER(a.name) LIKE UPPER(:name) GROUP BY a.id", nativeQuery = true)
    List<Book> getMostPublishedByAuthorPartial(String name);

    @Query(value = "SELECT * FROM books b JOIN (SELECT max(b2.sold_amount/b2.published_amount) "
            + "AS max FROM books b2 JOIN authors a2 ON b2.author_id = a2.id "
            + "WHERE UPPER(a2.name) LIKE UPPER(:name) GROUP BY a2.id) AS ss "
            + "ON b.sold_amount/b.published_amount = ss.max JOIN authors a "
            + "ON a.id = b.author_id", nativeQuery = true)
    List<Book> getMostSuccessfulByAuthorPartial(String name);
}
