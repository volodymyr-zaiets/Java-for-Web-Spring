package com.example.service;

import com.example.entity.Book;
import com.example.entity.User;
import com.example.payload.request.UserRequest;
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
public class UserService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    public String add(UserRequest userRequest) {
        String response;
        if (!userRepository.existsByUsername(userRequest.getUsername())
                && !userRepository.existsByEmail(userRequest.getEmail())) {
            User user = new User(userRequest.getUsername(),
                    userRequest.getEmail(),
                    userRequest.getPassword());
            user = userRepository.save(user);
            response = "Saved user with username: "
                    + user.getUsername()
                    + "(UUID = " + user.getUuid() + ")";
        } else {
            response = "User with the same username or email already exists";
        }
        return response;
    }

    public User getByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    @Transactional
    public String deleteByUuid(String uuid) {
        String response;
        if (userRepository.existsByUuid(uuid)) {
            userRepository.deleteByUuid(uuid);
            response = "Deleted user with uuid: " + uuid;
        } else {
            response = "Can't find user with uuid: " + uuid;
        }
        return response;
    }

    public String addAll(List<UserRequest> userRequests) {
        String response;
        AtomicReference<String> message = new AtomicReference<>("");
        List<User> users = userRequests.stream()
                .map(userRequest -> {
                    if (!userRepository.existsByUsername(userRequest.getUsername())
                            && !userRepository.existsByEmail(userRequest.getEmail())) {
                        return new User(userRequest.getUsername(),
                                userRequest.getEmail(),
                                userRequest.getPassword());
                    } else {
                        return null;
                    }
                })
                .filter(user -> {
                    if (user == null) {
                        message.set("Some users already exist by username or email!\n");
                    }
                    return Objects.nonNull(user);
                })
                .collect(Collectors.toList());
        if (!users.isEmpty()) {
            response = message + "Saved users with usernames: " + userRepository.saveAll(users)
                    .stream()
                    .map(user -> user.getUsername()
                            + "(UUID = " + user.getUuid() + ")")
                    .collect(Collectors.joining(", "));
        } else {
            response = "All users with the same usernames or emails already exist";
        }
        return response;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String addBooks(String user_uuid, Set<String> book_uuids) {
        String response;
        if (userRepository.existsByUuid(user_uuid)) {
            User user = getByUuid(user_uuid);
            Set<Book> books = new HashSet<>();
            for (String uuid: book_uuids) {
                books.add(bookRepository.findByUuid(uuid));
            }
            user.addBooks(books);
            userRepository.save(user);
            response = "Added books with names:"
                    + books.stream()
                    .map(book -> book.getName()
                            + "(UUID = " + book.getUuid() + ")")
                    .collect(Collectors.joining(", "));
        } else {
            response = "Can't find user with uuid: " + user_uuid;
        }
        return response;
    }
}
