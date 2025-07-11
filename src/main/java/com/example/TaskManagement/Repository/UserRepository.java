package com.example.TaskManagement.Repository;

import com.example.TaskManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

}
