package com.example.Scheman.dao;

import com.example.Scheman.domain.Author;

import java.util.Optional;

public interface AuthorsDao {
    void create(Author author);

   Optional<Author>  findOne(long l);
}
