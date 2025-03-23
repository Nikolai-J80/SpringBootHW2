package ru.nikolai.springboothomework2.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import ru.nikolai.springboothomework2.exeption.InvalidCredentials;
import ru.nikolai.springboothomework2.exeption.UnauthorizedUser;
import ru.nikolai.springboothomework2.model.Authorities;
import ru.nikolai.springboothomework2.repository.UserRepository;

import java.util.List;

@Service

public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(@Valid String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}