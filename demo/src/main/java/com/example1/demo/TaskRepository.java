package com.example1.demo;

import com.seu_projeto.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);

    // Consulta para encontrar tarefas atrasadas
    List<Task> findByDeadlineBeforeAndStatusNot(LocalDate date, String status);
}