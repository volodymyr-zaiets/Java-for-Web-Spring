package com.example.repository;

import com.example.entity.Book;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByName(String name);

    boolean existsByUuid(String uuid);

    @NotNull
    List<Book> findAll();

    Book findByUuid(String uuid);

    void deleteByUuid(String uuid);

    @NotNull
    <S extends Book> S save(@NotNull S entity);

    @NotNull
    <S extends Book> List<S> saveAll(@NotNull Iterable<S> entities);
}
