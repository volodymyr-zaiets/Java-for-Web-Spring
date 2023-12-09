package com.example.controller;

import com.example.entity.Book;
import com.example.payload.request.BookRequest;
import com.example.service.BookService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.add(bookRequest));
    }

    @GetMapping("/book/{uuid}")
    public Book getBookByUuid(@PathVariable @NotNull String uuid) {
        return bookService.getByUuid(uuid);
    }

    @DeleteMapping("/book/{uuid}")
    public ResponseEntity<?> deleteBook(@PathVariable @NotNull String uuid) {
        return ResponseEntity.ok(bookService.deleteByUuid(uuid));
    }

    @PostMapping("/books")
    public ResponseEntity<?> addAllBooks(@RequestBody List<BookRequest> bookRequests) {
        return ResponseEntity.ok(bookService.addAll(bookRequests));
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }
}
