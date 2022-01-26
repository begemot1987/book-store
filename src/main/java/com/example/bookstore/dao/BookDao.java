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

    @Query(value = "select b.id, b.book_name, b.author_id, "
            + "b.published_amount, max(b.sold_amount) as sold_amount "
            + "FROM books b join authors a on b.author_id = a.id "
            + "where a.name like :name group by a.id", nativeQuery = true)
    List<Book> getMostSellingByAuthorPartial(String name);

    @Query(value = "select b.id, b.book_name, b.author_id, "
            + "max(b.published_amount) as published_amount, b.sold_amount "
            + "FROM books b join  authors a on b.author_id = a.id "
            + "where a.name like :name group by a.id", nativeQuery = true)
    List<Book> getMostPublishedByAuthorPartial(String name);

    @Query(value = "select * from books b join (select max(b2.sold_amount/b2.published_amount) "
            + "as max from books b2 join authors a2 on b2.author_id = a2.id "
            + "where a2.name like :name group by a2.id) as ss "
            + "on b.sold_amount/b.published_amount = ss.max join authors a "
            + "on a.id = b.author_id", nativeQuery = true)
    List<Book> getMostSuccessfulByAuthorPartial(String name);
}
