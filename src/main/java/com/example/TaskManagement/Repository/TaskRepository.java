package com.example.TaskManagement.Repository;

import com.example.TaskManagement.Model.Task;
import com.example.TaskManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser(User user);
}
