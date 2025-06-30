package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void existsByIsbn_shouldReturnTrueIfExists() {
        Book book = new Book(null, "Test", "Author", "9780000000000");
        bookRepository.save(book);

        assertTrue(bookRepository.existsByIsbn("9780000000000"));
    }
}
