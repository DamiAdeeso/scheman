package com.example.Scheman.dao;
import com.example.Scheman.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface BooksDao {
    void create (Book book);

   Optional<Book> find(String isbn);



}


