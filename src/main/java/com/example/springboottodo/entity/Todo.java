package com.example.springboottodo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "todo_item")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean done = false;
}
