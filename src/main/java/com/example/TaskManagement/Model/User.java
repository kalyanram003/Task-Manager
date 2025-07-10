package com.example.TaskManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;

    private List<String> roles=new ArrayList<>();

}
