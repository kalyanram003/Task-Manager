package com.example.TaskManagement.Controller;



import com.example.TaskManagement.Model.Task;
import com.example.TaskManagement.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private TaskService taskService;

    // Create task for a user
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, @RequestParam Long userId) {
        Task created = taskService.createTask(task, userId);
        return ResponseEntity.ok(created);
    }

    // Get all tasks for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    // Get all tasks (optional, for testing)
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // Delete a task by ID
    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}

