package com.example.webservice.services;

import com.example.webservice.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adi", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
