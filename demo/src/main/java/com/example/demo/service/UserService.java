package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User criar(User user) {
        // Lógica personalizada, se necessário
        return userRepository.save(user);
    }

    public User atualizar(Long id, User user) {
        // Lógica personalizada, se necessário
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deletar(Long id) {
        // Lógica personalizada, se necessário
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Outros métodos conforme necessário
}
