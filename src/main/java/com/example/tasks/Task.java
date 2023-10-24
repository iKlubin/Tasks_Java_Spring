package com.example.tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "mytasks")
public class Task {
    @Id
    private Long id;
    private String description;
    private boolean completed;

    public Task(Long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
