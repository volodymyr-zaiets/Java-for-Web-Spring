package com.example.controller;

import com.example.entity.User;
import com.example.payload.request.UserRequest;
import com.example.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.add(userRequest));
    }

    @GetMapping("/user/{uuid}")
    public User getUserByUuid(@PathVariable @NotNull String uuid) {
        return userService.getByUuid(uuid);
    }

    @DeleteMapping("/user/{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable @NotNull String uuid) {
        return ResponseEntity.ok(userService.deleteByUuid(uuid));
    }

    @PostMapping("/users")
    public ResponseEntity<?> addAllUsers(@RequestBody List<UserRequest> userRequests) {
        return ResponseEntity.ok(userService.addAll(userRequests));
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/user/{user_uuid}")
    public ResponseEntity<?> addBooksToUser(@PathVariable @NotNull String user_uuid,
                                            @RequestBody Set<String> book_uuids) {
        return ResponseEntity.ok(userService.addBooks(user_uuid, book_uuids));
    }
}
