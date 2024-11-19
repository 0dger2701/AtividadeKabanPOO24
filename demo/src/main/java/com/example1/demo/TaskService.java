package com.example1.demo;

import com.seu_projeto.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.seu_projeto.model.Task;
import com.seu_projeto.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        task.setStatus("A Fazer");
        return taskRepository.save(task);
    }

    public List<Task> listTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public Task moveTask(Task task) {
        switch (task.getStatus()) {
            case "A Fazer" -> task.setStatus("Em Progresso");
            case "Em Progresso" -> task.setStatus("Concluído");
            default -> throw new IllegalArgumentException("Tarefa já concluída");
        }
        return taskRepository.save(task);
    }
}
