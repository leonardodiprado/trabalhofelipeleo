package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> listarTarefas() {
        return taskRepository.findAll();
    }

    public Task criar(Task task) {
        // Lógica personalizada, se necessário
        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task task) {
        // Lógica personalizada, se necessário
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    public boolean deletar(Long id) {
        // Lógica personalizada, se necessário
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Outros métodos conforme necessário
}
