package com.example;

import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class RepositoryTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);

    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);

    @Test
    public void findAllUsersTest() {
        System.out.println(userRepository.findAll().size());
    }

    @Test
    public void findUserByUuidTest() {
        System.out.println(userRepository.findByUuid("0"));
    }

    @Test
    public void findAllBooksTest() {
        System.out.println(bookRepository.findAll().size());
    }

    @Test
    public void findBookByUuidTest() {
        System.out.println(bookRepository.findByUuid("0"));
    }
}
