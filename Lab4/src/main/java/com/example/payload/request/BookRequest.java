package com.example.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Set<String> authors;
}
