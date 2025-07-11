package com.example.TaskManagement.Service;


import com.example.TaskManagement.Model.Task;
import com.example.TaskManagement.Model.User;
import com.example.TaskManagement.Repository.TaskRepository;
import com.example.TaskManagement.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private  TaskRepository taskRepository;
    private  UserRepository userRepository;

    public Task createTask(Task task, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            task.setUser(userOpt.get());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public List<Task> getTasksByUserId(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        return userOpt.map(taskRepository::findByUser)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found with id: " + taskId);
        }
        taskRepository.deleteById(taskId);
    }
}
