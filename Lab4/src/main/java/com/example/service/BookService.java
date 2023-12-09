package com.example.service;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.payload.request.BookRequest;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final UserRepository userRepository;

    public String add(BookRequest bookRequest) {
        String response;
        if (!bookRepository.existsByName(bookRequest.getName())) {
            Set<User> authors = new HashSet<>();
            for (String uuid: bookRequest.getAuthors()) {
                authors.add(userRepository.findByUuid(uuid));
            }
            Book book = new Book(bookRequest.getName(), authors);
            book = bookRepository.save(book);
            response = "Saved book with name: "
                    + book.getName()
                    + "(UUID = " + book.getUuid() + ")";
        } else {
            response = "Book with the same name already exists";
        }
        return response;
    }

    public Book getByUuid(String uuid) {
        return bookRepository.findByUuid(uuid);
    }

    @Transactional
    public String deleteByUuid(String uuid) {
        String response;
        if (bookRepository.existsByUuid(uuid)) {
            bookRepository.deleteByUuid(uuid);
            response = "Deleted book with uuid: " + uuid;
        } else {
            response = "Can't find book with uuid: " + uuid;
        }
        return response;
    }

    public String addAll(List<BookRequest> bookRequests) {
        String response;
        AtomicReference<String> message = new AtomicReference<>("");
        List<Book> books = bookRequests.stream()
                .map(bookRequest -> {
                    if (!bookRepository.existsByName(bookRequest.getName())) {
                        Set<User> authors = new HashSet<>();
                        for (String uuid: bookRequest.getAuthors()) {
                            authors.add(userRepository.findByUuid(uuid));
                        }
                        return new Book(bookRequest.getName(), authors);
                    } else {
                        return null;
                    }
                })
                .filter(book -> {
                    if (book == null) {
                        message.set("Some books already exist by name!\n");
                    }
                    return Objects.nonNull(book);
                })
                .collect(Collectors.toList());
        if (!books.isEmpty()) {
            response = message + "Saved books with names: " + bookRepository.saveAll(books)
                    .stream()
                    .map(book -> book.getName()
                            + "(UUID = " + book.getUuid() + ")")
                    .collect(Collectors.joining(", "));
        } else {
            response = "All books with the same names already exist";
        }
        return response;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
