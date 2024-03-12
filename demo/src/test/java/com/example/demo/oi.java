package com.example.demo;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskListApplicationTests {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        // Verifica se o contexto da aplicação carrega corretamente
    }

    @Test
    void testCreateAndRetrieveTask() {
        Task task = new Task();
        task.setDescricao("Realizar teste");
        task.setDataConclusao(LocalDate.now().plusDays(7));

        taskService.criar(task);

        Task retrievedTask = taskService.listarTarefas().get(0);

        assertNotNull(retrievedTask);
        assertEquals("Realizar teste", retrievedTask.getDescricao());
        assertEquals(LocalDate.now().plusDays(7), retrievedTask.getDataConclusao());
    }

    @Test
    void testCreateAndRetrieveUser() {
        User user = new User();
        user.setNome("John Doe");
        user.setEmail("john.doe@example.com");

        userService.criar(user);

        User retrievedUser = userService.listarUsuarios().get(0);

        assertNotNull(retrievedUser);
        assertEquals("John Doe", retrievedUser.getNome());
        assertEquals("john.doe@example.com", retrievedUser.getEmail());
    }

    // Adicione mais testes conforme necessário

    @Test
    void testUpdateTask() {
        Task task = new Task();
        task.setDescricao("Tarefa a ser atualizada");
        task.setDataConclusao(LocalDate.now().plusDays(14));

        taskService.criar(task);

        Task updatedTask = new Task();
        updatedTask.setDescricao("Tarefa Atualizada");
        updatedTask.setDataConclusao(LocalDate.now().plusDays(21));

        taskService.atualizar(task.getId(), updatedTask);

        Task retrievedTask = taskService.listarTarefas().get(0);

        assertNotNull(retrievedTask);
        assertEquals("Tarefa Atualizada", retrievedTask.getDescricao());
        assertEquals(LocalDate.now().plusDays(21), retrievedTask.getDataConclusao());
    }

    // Adicione mais testes conforme necessário
}
