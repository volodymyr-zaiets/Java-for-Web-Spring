package com.example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Setter(AccessLevel.NONE)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "author")
    @JoinTable(  name = "book_authors",
            joinColumns = @JoinColumn(name = "book_uuid"),
            inverseJoinColumns = @JoinColumn(name = "authors_uuid"))
    private Set<User> authors;

    public Book(String name, Set<User> authors) {
        this.name = name;
        this.authors = authors;
    }

    @PrePersist
    public void onCreate() {
        uuid = UUID.randomUUID().toString();
    }
}
