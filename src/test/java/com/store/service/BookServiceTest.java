package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ISBNGenerator isbnGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBook_shouldSaveWithGeneratedISBN() {
        BookDTO dto = new BookDTO(null, "Java 101", "John Smith");

        when(isbnGenerator.generateISBN()).thenReturn("9781234567890");
        when(bookRepository.existsByIsbn("9781234567890")).thenReturn(false);
        when(bookRepository.save(any(Book.class)))
                .thenAnswer(i -> {
                    Book b = i.getArgument(0);
                    b.setId(1L);
                    return b;
                });

        BookDTO result = bookService.createBook(dto);

        assertEquals("Java 101", result.getTitle());
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void getBook_shouldThrowExceptionIfNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> bookService.getBook(1L));
    }
}
