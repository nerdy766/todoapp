package com.tasks.todoapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String name;
  private LocalDate createdAt;
  @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
  private List<Task> taskList;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
