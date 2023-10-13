package me.reach.rocketseat.models;

import jakarta.persistence.*;
import lombok.Data;
import me.reach.rocketseat.enums.TaskPriorityEnum;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "be_tasks")
public class TaskModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 20)
    private String title;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority = TaskPriorityEnum.LOW;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private UUID userId;



}
