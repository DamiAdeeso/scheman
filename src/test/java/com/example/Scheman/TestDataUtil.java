package com.example.Scheman;

import com.example.Scheman.domain.Author;

public final class TestDataUtil {

        private TestDataUtil(

        ){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("ade")
                .age(12)
                .build();
    }
}
