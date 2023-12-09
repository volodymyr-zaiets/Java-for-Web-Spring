package com.example.repository;

import com.example.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUuid(String uuid);

    @NotNull
    List<User> findAll();

    User findByUuid(String uuid);

    void deleteByUuid(String uuid);

    @NotNull
    <S extends User> S save(@NotNull S entity);

    @NotNull
    <S extends User> List<S> saveAll(@NotNull Iterable<S> entities);
}
