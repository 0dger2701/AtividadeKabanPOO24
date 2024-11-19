package com.example1.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String status = "A Fazer"; // Valores: "A Fazer", "Em Progresso", "Concluído"
    private String priority; // Valores: "Baixa", "Média", "Alta"
    private LocalDate deadline; // Opcional

    // Getters e Setters
}