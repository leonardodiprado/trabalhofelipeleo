package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> listarTarefas() {
        return taskService.listarTarefas();
    }

    @PostMapping
    public Task criar(@Valid @RequestBody Task task) {
        return taskService.criar(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.atualizar(id, task);
        if (updatedTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe na base de dados.");
        }
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (taskService.deletar(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("A deleção do id: " + id + " foi realizada com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe na base de dados.");
    }

    // Outros métodos conforme necessário
}
