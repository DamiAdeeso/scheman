package com.example.Scheman.dao.impl;

import com.example.Scheman.dao.BooksDao;
import com.example.Scheman.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;

public class BooksDaoImpl implements BooksDao {
    private final JdbcTemplate jdbcTemplate;

    public BooksDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate =jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT into books (isbn,title,author_id) Values (?,?,?)",
                book.getIsbn(),
                book.getTitle(),
                book.getAuthorId()
        );
    }

    @Override
    public Optional<Book> find(String isbn) {
        List<Book> results =  jdbcTemplate.query("SELECT isbn,title,author_id from books WHERE id = ? LIMIT 1",new BookRowMapper(),isbn );

        return results.stream().findFirst();
    }
    public static class BookRowMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
           return  Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong ("author_id"))
                    .build();
        }
    }

}