package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void createBook_shouldReturnCreatedBook() throws Exception {
        BookDTO bookDTO = new BookDTO(null, "Test Title", "Test Author");

        Mockito.when(bookService.createBook(Mockito.any())).thenReturn(bookDTO);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Test Title\",\"author\":\"Test Author\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Title"));
    }

    @Test
    void getBook_shouldReturnBook() throws Exception {
        BookDTO bookDTO = new BookDTO(1L, "Title", "Author");

        Mockito.when(bookService.getBook(1L)).thenReturn(bookDTO);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Author"));
    }
}
