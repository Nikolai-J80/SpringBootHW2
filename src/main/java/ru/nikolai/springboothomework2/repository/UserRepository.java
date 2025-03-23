package ru.nikolai.springboothomework2.repository;

import org.springframework.stereotype.Repository;
import ru.nikolai.springboothomework2.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("Nik") && password.equals("4455")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Bob") && password.equals("321")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        }
        return authorities;
    }
}