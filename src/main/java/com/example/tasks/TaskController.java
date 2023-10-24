package com.example.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "task/list";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskRepository.save(new Task(ThreadLocalRandom.current().nextLong(1, 1000), task.getDescription(), task.isCompleted()));
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task/edit";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskRepository.deleteById(id);
        taskRepository.save(new Task(id, task.getDescription(), task.isCompleted()));
        return "redirect:/tasks";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteTaskForm(@PathVariable Long id, Model model) {
//        Optional<Task> task = taskRepository.findById(id);
//        if (task.isPresent()) {
//            model.addAttribute("task", task.get());
//            return "task/delete";
//        } else {
//            // Обработка случая, когда задача не найдена
//            return "redirect:/tasks";
//        }
//    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }
}
