package com.example.webservice.services;

import com.example.webservice.models.User;
import com.example.webservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return this.userRepository.findById(id);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }
}
