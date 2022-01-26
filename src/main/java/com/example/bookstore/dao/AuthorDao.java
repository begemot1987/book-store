package com.example.bookstore.dao;

import com.example.bookstore.dto.response.AuthorDaoResponseDto;
import com.example.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    @Query(value = "select t.id, t.author as name, t.bd as birthDay, "
            + "t.phone as phone, t.email as email, sum(t.sbr) as rate "
            + "from (select "
            + "((select max(b.sold_amount/b.published_amount) "
            + "from books b2 "
            + "join authors a3 "
            + "on b.author_id = a3.id "
            + "where b.id = b2.id) / "
            + "(select count(b.book_name) "
            + "from books b "
            + "join authors a2 "
            + "on b.author_id = a2.id "
            + "where a2.id = a.id)) as sbr, a.id as id, a.name as author, "
            + "a.birth_date as bd, a.phone as phone, a.email as email "
            + "from books b "
            + "join authors a "
            + "on b.author_id = a.id "
            + "group by b.id, a.id) as t "
            + "group by t.id "
            + "order by rate desc "
            + "limit 1", nativeQuery = true)
    AuthorDaoResponseDto getMostSuccessful();
}
