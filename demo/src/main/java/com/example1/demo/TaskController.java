package com.example1.demo;

import com.seu_projeto.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.seu_projeto.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> listTasks(@RequestParam String status) {
        return ResponseEntity.ok(taskService.listTasksByStatus(status));
    }

    @PutMapping("/{id}/move")
    public ResponseEntity<Task> moveTask(@PathVariable Long id) {
        Task task = taskService.moveTask(taskService.findTaskById(id));
        return ResponseEntity.ok(task);
    }
}
