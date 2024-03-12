package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PostMapping
    public User criar(@Valid @RequestBody User user) {
        return userService.criar(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.atualizar(id, user);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe na base de dados.");
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (userService.deletar(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("A deleção do id: " + id + " foi realizada com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe na base de dados.");
    }

    // Outros métodos conforme necessário
}
